import React, {useState, createContext, ReactNode, useEffect} from "react";
import { TaskProps, TaskListType } from "./taskType";
import { useGetTasks } from "../Hooks/useGetTasks";
import { axiosInstanceBaseApp } from "../Constants/axiosInstance";

interface ChildrenProps {
    children: React.ReactNode;
  }

export const TaskListContext = createContext<TaskListType|null>(null);

export const TaskListContextProvider: React.FC<ChildrenProps> = ({children}) =>{
    const { data, isLoading } = useGetTasks();
    const [taskList, setTaskList] = useState<TaskProps[]>(data || []);
    const [firstLoading, setFirstLoading] = useState<boolean>(true);

    useEffect(() => {
            if (data && !isLoading && firstLoading) {
                setTaskList(data);
                setFirstLoading(false);
            }
    }, [data, isLoading])

    const [doneTasks, setDoneTasks] = useState<TaskProps[]>(taskList.filter((task:TaskProps) => task.done==true));
    const [notDoneTasks, setNotDoneTasks] = useState<TaskProps[]>(taskList.filter((task:TaskProps) => task.done==false));

    const addTask = (task: TaskProps) => {
        taskList.push(task)
        setTaskList([...taskList]);
        console.log(taskList)
        setNotDoneTasks([...notDoneTasks, task]);
        axiosInstanceBaseApp.post('/tasks', {
            userid: 1,
            ...task,
        });
    };

    const checkTask = async (id:number)=>{
        const task = taskList.find((task: TaskProps) => {
            if (task.id === id) {
              task.done = !task.done
              setTaskList([...taskList]);
              setDoneTasks(taskList.filter((task:TaskProps) => task.done==true));
              setNotDoneTasks(taskList.filter((task:TaskProps) => task.done!=true));
              return task
            }
        });
        if (task) {
            await axiosInstanceBaseApp.put('/tasks/field', {
                isDone: task.done ? 1 : 0,
                taskid: task.id,
              })
        }
    };

    const deleteTask = (id:number)=>{
        const task = taskList.find((task:TaskProps)=>task.id == id);
        const index = taskList.findIndex((task:TaskProps)=>task.id == id);
        taskList.splice(index,1);
        setTaskList([...taskList]);
        setDoneTasks(taskList.filter((task:TaskProps) => task.done==true));
        setNotDoneTasks(taskList.filter((task:TaskProps) => task.done!=true));
        axiosInstanceBaseApp.delete('/tasks/' + task?.id);
    };

    return(
        <TaskListContext.Provider value={{taskList, doneTasks,notDoneTasks, addTask, checkTask, deleteTask}}>
            {children}
        </TaskListContext.Provider>
    )
}


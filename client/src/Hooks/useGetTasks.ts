import { axiosInstanceBaseApp } from "../Constants/axiosInstance";
import { API_ROUTES } from "../Constants/apiEndpoint";
import { useQuery } from "react-query";

export const useGetTasks = () => {
  return useQuery({
    queryKey: ['templates'],
    queryFn: () =>
      axiosInstanceBaseApp
        .get(API_ROUTES.TASKS)
        .then((res) => res.data),
    select: (data) => {
      const formatedData = data.map((item: any) => {
        return {
          id: item.taskid,
          title: item.title,
          done: item.isDone === 1,
          categorie: item.categorie,
          color: "#FF9C9C"
        };
      }
      );
      return formatedData;
    },
  });
}

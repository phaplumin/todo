import axios from "axios";
import { API_ENDPOINT } from "./apiEndpoint";

export const axiosInstanceBaseApp = axios.create({
  baseURL: API_ENDPOINT,
});
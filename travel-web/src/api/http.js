import axios from "axios";

const BASE_API = import.meta.env.VITE_BASE_API || "/api"; // dev=proxy, prod=env
const http = axios.create({
  baseURL: BASE_API,
  timeout: 10000,
});

export default http;
export { http };
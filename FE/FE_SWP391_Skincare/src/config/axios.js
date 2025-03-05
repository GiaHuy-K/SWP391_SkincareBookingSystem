import axios from "axios";

const api = axios.create({
    // baseURL: 'http://222.255.117.200:8080/api'

    baseURL: 'http://localhost:8080/api'

    // baseURL:"https://67c7f701c19eb8753e7b8e9f.mockapi.io/"
});
api.interceptors.request.use(
    function (config) {
      // Do something before request is sent
      const token = localStorage.getItem("token");
      if (token) {
        config.headers.Authorization = `Bearer ${token}`;
      }
      return config;
    },
    function (error) {
      return Promise.reject(error);
    }
  );

export default api;
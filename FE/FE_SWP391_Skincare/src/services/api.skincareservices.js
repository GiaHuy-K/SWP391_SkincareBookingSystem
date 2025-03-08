import { toast } from "react-toastify";
import api from "../config/axios"

export const getSkinCareServices = async() =>{
    try {
        const response = await api.get("/admin/skinCareServiceAll");
        return response.data;
      } catch (error) {
        toast.error("Failed to fetch services");
      } 
}
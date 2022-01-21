import {getUserData} from "./LoginService";
import {AxiosResponse} from "axios";

const axios = require('axios').default;

const getConfig = () => ({headers: {'Authorization': 'Bearer ' + getUserData().authToken}})

export const getAllLists = () =>
    axios.get("/api/lists/", getConfig()).then((response: AxiosResponse) => response.data)

export const getListById = (id: string) =>
    axios.get(`/api/lists/${id}`, getConfig()).then((response: AxiosResponse) => response.data)

export const addNewList = (newList: {}) =>
    axios.post("/api/lists/", getConfig()).then((response: AxiosResponse) => response.data)

export const changeListName = (newList: {}) =>
    axios.put("/api/lists/", getConfig()).then((response: AxiosResponse) => response.data)

export const deleteList = (id: string) =>
    axios.delete(`/api/lists/${id}`, getConfig()).then(console.log)
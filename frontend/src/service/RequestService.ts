import axios from 'axios'

// export const api: string = "http://localhost:5000/api"
//
// export default function requestService(){
//
// }

export const getAllLists = () => axios.get('/api/lists').then(response => response.data)

export const getListById = id => axios.get(`/api/lists/${id}`).then(response => response.data)

export const createNewList = listName => axios.post('/api/lists', {listName: listName})

export const editListName = list => axios.put(`api/lists/${list.id}`, list)

export const removeList = id => axios.delete(`/api/lists/${id}`)
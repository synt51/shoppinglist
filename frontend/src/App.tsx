import React, {useEffect, useState} from 'react';
import './App.scss';
import axios from 'axios';
import Home from './pages/Home'
import NavBar from './components/NavBar';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Change from "./pages/ChangeItem";
import itemController, {IItemController} from "./controller/itemController";
import ListPage from "./pages/ListPage";
import {IListController} from "./controller/listController";
import {Switch} from "@mui/material";

export default function App() {
    // const itemController: IItemController = itemController()
    // const listController: IListController= listController()

    //return (
        // <div className="App">
        //     <BrowserRouter>
        //         <NavBar />
        //         <Routes>
        //             <Route path={"/"} element={<Home controller={itemController}/>}/>
        //             <Route path={"/change/item/:name"} element={<Change controller={itemController}/>}/>
        //             <Route path={"/lists"} element={<ListPage controller={listController}/>}/>
        //         </Routes>
        //     </BrowserRouter>
        // </div>
    //);

    const [lists, setLists] = useState([])

    useEffect (() => {
        getAllLists()
            .then(lists => setLists(lists))
            .catch(error => console.error(error))
    }, [])

    const createNewList = listName =>
        postList(listName)
            .then(()=>getAllLists())
            .then(lists => setLists(lists))
            .catch(error => console.error(error))

    const removeList = listId =>
        deleteList(listId)
            .then(()=> getAllLists())
            .then(lists => setLists(lists))
            .catch(error=> console.error(error))

    const editListName = list =>
        putListName(list)
            .then(()=> getAllLists())
            .then(lists => setLists(lists))
            .catch(error=> console.error(error))



    return(
      <BrowserRouter>
          <NavBar/>
          <Route path={"/"}>
              <Home
                  createNewList={createNewList}
                  lists={lists}
                  removeList={removeList}
                  editListName={editListName}
                  />
          </Route>
          <Route path={"/list/:listName"}>
              <ListPage
                  items={items}
                  changeItemName{changeItemName}
                  decreaseCount={decreaseCount}
                  increaseCount={increaseCount}
                  removeItem={removeItem}
              />
          </Route>
          <Route path={"/edit/list/:listName"}>
              <EditList
                  changeListName={changeListName}
                  />
          </Route>
      </BrowserRouter>
    );
}

import React, {useEffect, useState} from 'react';
import './App.scss';
import axios from 'axios';
import Home from './pages/Home'
import NavBar from './components/NavBar';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import ChangeItem from "./pages/ChangeItem";
import itemController from "./controller/itemController";
import ListPage from "./pages/ListPage";
import listController from "./controller/listController";
import ChangeList from "./pages/ChangeList";
import {IItem, IItemController} from "./models/ShoppingItems";
import {IList, IListController} from "./models/ShoppingLists";
import ItemAPIController from "./controller/itemAPIController";
import ListAPIController from "./controller/listAPIController";
import ItemController from "./controller/itemController";
import ListController from "./controller/listController";

export default function App() {

    const [items, setItems] = useState<IItem[]>([])
    const [lists, setLists] = useState<IList[]>([])
    const itemAPIController: IItemController = ItemAPIController();
    const listAPIController: IListController = ListAPIController();
    const itemController: IItemController = ItemController(itemAPIController, setItems)
    const listController: IListController = ListController(listAPIController, setLists)

    return (

        <div className="App">
            <BrowserRouter>
                <NavBar/>
                <Routes>
                    <Route path={"/"} element={<Home controller={listController} lists={lists}/>}/>
                    <Route path={"/list/:listName"} element={<ListPage controller={itemController} items={items}/>}/>
                    <Route path={"/edit/list/:listName"} element={<ChangeList controller={listController}/>}/>
                    <Route path={"/edit/item/:itemName"} element={<ChangeItem controller={itemController}/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

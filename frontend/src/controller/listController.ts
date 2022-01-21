import {IListController, IListSetter} from "../models/ShoppingLists";

export default function ListController(apiController: IListController, setter: IListSetter): IListController {
    return {
        getLists: () => {
            apiController.getLists()!.then(setter)
        },
        addList(listName) {
            apiController.addList(listName)!.then(setter)
        },
        removeList(listName) {
            apiController.removeList(listName)!.then(setter)
        }
    }
}
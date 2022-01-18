import {IListController} from "../controller/listController";
import {useNavigate, useParams} from "react-router-dom";
import React from "react";
import {faExchangeAlt} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

export default function ChangeList(props: {controller: IListController}) {
    const {controller} = props
    const params = useParams()
    const navigate = useNavigate()
    const name: string = params.name!

    const changeList: React.FormEventHandler<HTMLFormElement> = (event) => {
        // @ts-ignore
        controller.changeList(name, event.target.elements[0].value)
        event.preventDefault()
        navigate("/")
    }

    return (
        <div className={"App-header"}>
            <h1>{name}</h1>
            <div className={"ChangeBox"}>
                <form onSubmit={changeList}>
                    <input className={"ChangeItemText"} type="text" placeholder={"Add new item name..."}/>
                    <button type="submit"/>
                    <FontAwesomeIcon icon={faExchangeAlt}/>
                </form>
            </div>
        </div>
    )
}
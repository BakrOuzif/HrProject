import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import React, {createContext, useState} from "react";
import {Header, SideBar} from "./Collabs/Containers";
import CollabListPage from "./Collabs/CollabListPage";
import CollabAddPage from "./Collabs/CollabAddPage";
import CollabMListPage from "./ManagersRH/CollabListPage";
import ManagerRHPage from "./ManagersRH/ManagerRHPage";

function Routing() {

    return (
        <Router>
            <div className="CollabPage">
                <SideBar/>
                <div className="CollabPage__stretch">
                    <Header/>
                    <Switch>
                        <Route exact path="/" key={"home"}>
                            <CollabListPage/>
                        </Route>
                        <Route path="/add" key={"add"}>
                            <CollabAddPage/>
                        </Route>
                        <Route path="/collabm" key={"notmanager"}>
                            <CollabMListPage/>
                        </Route>
                        <Route path="/manager" key={"manager"}>
                            <ManagerRHPage/>
                        </Route>
                    </Switch>
                </div>
            </div>
        </Router>
    )
}

export default Routing;
import './ManagerPage.css';

import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import React from "react";
import {Header, SideBar} from "./Containers";
import ManagerRHPage from "./ManagerRHPage";
import CollabMListPage from "./CollabListPage";

function ManagerPage() {
    return (
        <Router>
            <div className="ManagerPage">
                <SideBar/>
                <div className="ManagerPage__stretch">
                    <Header/>
                    <Switch>
                        <Route exact path="/collabm">
                            <CollabMListPage/>
                        </Route>
                    </Switch>
                        <Route exact path="/manager">
                            <ManagerRHPage/>
                        </Route>
                </div>
            </div>
        </Router>
    );
}

export default ManagerPage;

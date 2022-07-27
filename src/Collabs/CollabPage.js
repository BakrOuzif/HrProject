import './CollabPage.css';

import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import CollabAddPage from "./CollabAddPage";
import CollabListPage from "./CollabListPage";
import React from "react";
import {Header, SideBar} from "./Containers";

function CollabPage() {
    return (
        <Router>
            <div className="CollabPage">
                <SideBar/>
                <div className="CollabPage__stretch">
                    <Header/>
                    <Switch>
                        <Route exact path="/">
                            <CollabListPage/>
                        </Route>
                        <Route exact path="/add">
                            <CollabAddPage/>
                        </Route>
                    </Switch>
                </div>
            </div>
        </Router>
    );
}

export default CollabPage;

import './CollabListPage.css';

import {SideBar, List, Header} from './Containers'

function CollabListPage() {
  return (
    <div className="CollabListPage">
        <SideBar/>
        <div className="CollabListPage__stretch">
            <Header/>
            <List/>
        </div>
    </div>
  );
}

export default CollabListPage;

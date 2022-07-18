import './CollabAddPage.css';

import {SideBar, Header, AddCollab} from './Containers'

function CollabListPage() {
  return (
    <div className="CollabAddPage">
        <SideBar/>
        <div className="CollabAddPage__stretch">
            <Header/>
            <AddCollab/>
        </div>
    </div>
  );
}

export default CollabListPage;

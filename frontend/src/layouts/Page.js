import React from 'react';
import { Route, Switch } from 'react-router-dom';
import Main from '../components/Main';


const Page = () => {
    return(
        <>
            <Switch>
            <Route path="/" exact component={Main}/>
            </Switch>
        </>
    )
}

export default Page;
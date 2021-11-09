import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Home from './components/Home.js';
import Products from './components/Products.js'


const image = { uri: "https://reactjs.org/logo-og.png" };

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path='/' exact>
            <Home/>
          </Route>
          <Route path='/products' exact>
            <Products/>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}


export default App;

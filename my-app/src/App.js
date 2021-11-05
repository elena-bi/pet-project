import React from 'react';
// import { ImageBackground, StyleSheet, Text, View } from 'react-native';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Navbar from './components/Navbar';
// import Image from '../src/images/background-1.jpg'
import ImageSlider from './components/ImageSlider';
import { SliderData } from './components/SliderData';

const image = { uri: "https://reactjs.org/logo-og.png" };

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />

        <ImageSlider slides={SliderData} />

        <Switch>
          <Route path='/' exact></Route>
        </Switch>
      </Router>
    </div>
  );
}


export default App;

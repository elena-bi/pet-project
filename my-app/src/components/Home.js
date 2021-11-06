import React from 'react';
import Navbar from './Navbar';
import ImageSlider from './ImageSlider';
import { SliderData } from './SliderData';

function Home() {
    return (
        <div>
            <Navbar />
            <ImageSlider slides={SliderData} />
        </div>
    )
}

export default Home

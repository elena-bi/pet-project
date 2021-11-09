import React from 'react';
import './Card.css';


function CardContent({props}) {
    return (
        <div className="card">
            <div className="card-img">
                <img className="product-img" src='https://images.unsplash.com/photo-1501446529957-6226bd447c46?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1489&q=80' alt="an image should be here" />

            </div>
            <div className="body-card">
                <h1 className="title">{props.title}</h1>
                <p className="description">{props.content} </p>
                <div class="product-price-btn">
                    <p><span>258</span>$</p>
                    <button type="button">buy now</button>
                </div>
            </div>

        </div>
    )
}

export default CardContent

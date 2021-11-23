import React from 'react';
import './Card.css';


function Card({props}) {
    return (
        <div className="card">
            <div className="card-img">
                <img className="product-img" src={`http://localhost:8080/api/v1/products/${props.cardId}/image/download`} alt="" />

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

export default Card

import React, { useState } from 'react';
import axios from 'axios';

function TradeForm() {
    const [trade, setTrade] = useState('');

    const handleSubmit = async (e) => {

        e.preventDefault();
        try {
            await axios.post("http://localhost:8080/api/trades", trade);
            return "Trade sent successfully!";

        }catch(error) {
            console.log("There was an error sending the trade: ", error.message)
        }
    }

    return (
        <form onSubmit={handleSubmit}>
            <input
            type="text"
            value={trade}
            onChange={(e) => setTrade(e.target.value)}
            placeholder='Enter trade details'
            />
            <button type="submit">Send Trade</button>
        </form>
    )

}
export default TradeForm;
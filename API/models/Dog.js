const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const DogSchema = new Schema({
    name: {
        type: String,
        require: true,
        trim: true
    },
    breed:{
        type: String,
        require: true,
        trim: true
    },
    female: {
        type: Boolean, 
        require: true
    },
    weight: {
        type: Number,
        require: true,
        trim: true
    },
    color: {
        type: String,
        require: true,
        trim: true
    },
    birth:{
        type: Date,
        require: true
    },
    sterilized: {
        type: Boolean,
        require: true
    }
},
 {
    timestamps: true
});

DogSchema.methods = {
    
};


module.exports = mongoose.model("Dog", DogSchema);
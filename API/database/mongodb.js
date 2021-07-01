const debug = require("debug")("app:mongoose");
const mongoose = require("mongoose");

const dburi = process.env.DBURI;
const connect = async () => {
    try {
        await mongoose.connect(dburi, {
            useNewUrlParser: true,
            useUnifiedTopology: true,
            useCreateIndex: true,
            useFindAndModify: false
        });
        debug("Conexion exitosa con la base");
    }catch(error) {
        console.log(error);
        debug("No se pudo conectar con la base");
        process.exit(1)
    }
}

module.exports = {
    connect
}
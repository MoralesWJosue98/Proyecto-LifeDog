const User = require('../models/User');
const debug = require('debug')('Http')
const { createToken, verifyToken } = require('../utils/jwt');

const UserController = {
    createUser : async (req, res) => {
        const {user, password, email } = req.body;
        try{
            const findedUser = await User.findOne({email : email});
            if(findedUser != null){
                throw {error: true, message: "El usuario ya ha sido registrado"}
            }

            const newUser = new User({
                username: user,
                password: password,
                email: email
            });
            
            await newUser.save();
            return res.status(201).json({error: false, message: "Usuario creado con éxito."});
        }
        catch(err){
            return res.status(400).json(err)
        }
    },

    loginUser : async (req, res) => {
        const { email, password } = req.body
        try {
            const user = await User.findOne({email: email});
            
            if(user == null){
                throw {error: true, message: "El email ingresado es incorrecto."};
            }
            const passwordIsCorrect = user.comparePasswords(password);
            if(!passwordIsCorrect){
                throw {error: true, message: "La contraseña es incorrecta."}
            }

            const token = createToken(user._id);
            const canLogIn = await  insertValidToken(user,token);
            
            if(!canLogIn){
                return res.status(409).json({error: "Error al loguearse."});
            }

            return res.status(200).json({error: false, token: token, message: "Usuario logueado con éxito"})
        } catch (err) {
            console.log(err);
            return res.status(400).json(err)
        }
    },

    getAll: async (req, res) => {
        try{
            const usuarios = await User.find({});
            return res.status(200).json({error: false, usuarios: usuarios});
        }
        catch(err){
            console.log(err);
            return res.status(400).json(err)
        }
    }
}

const insertValidToken = async (user, token) => {
    try {
        user.validTokens = user.validTokens.filter(token => verifyToken(token));
        const newTokens = [token, ...user.validTokens.slice(0,4)];

        user.validTokens = newTokens;

        const userSaved = await user.save();
        if(!userSaved) return false; 

        return true;
    }catch(error) {
        throw error;
    }
}

module.exports = UserController
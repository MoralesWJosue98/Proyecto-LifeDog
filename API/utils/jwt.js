const jwt = require("jsonwebtoken");

const secret = process.env.JWTSECRET || "Secret"
const expTime = process.env.JWTEXPTIME || "5m"

const tools = {
    createToken: (_id) => {
        const payload = {
            _id
        };
    
        return jwt.sign(payload, secret, {
            expiresIn: expTime
        });
    },
    verifyToken: (token) => {
        try {
            return jwt.verify(token, secret)
        } catch {
            return false;
        }
    }
}

module.exports = tools;
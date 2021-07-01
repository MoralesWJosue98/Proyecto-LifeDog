var express = require('express');
var router = express.Router();
var usersRouter = require('./user');

router.use('/user', usersRouter);

module.exports = router;

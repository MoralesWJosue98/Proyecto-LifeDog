var express = require('express');
var router = express.Router();
var usersRouter = require('./user');
var DogRouter = require('./dog');

router.use('/user', usersRouter);
router.use('/dog', DogRouter);

module.exports = router;

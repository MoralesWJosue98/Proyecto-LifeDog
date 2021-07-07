var express = require('express');
var router = express.Router();
const {create, update, findAll, deleteDog } = require('../../controllers/DogController');

router.get('/', findAll);
router.post('/', create);
router.put('/', update);
router.delete('/', deleteDog);

module.exports = router;
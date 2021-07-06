const Dog = require('../models/Dog');

const DogController = {
    create: async (req, res) => {
        const { name, breed, female, weight, color, birth, sterilized } = req.body; 
        try {
            const newDog = new Dog({
                name : name,
                breed: breed,
                female: female,
                weight: weight,
                color: color,
                birth: birth,
                sterilized: sterilized
            });

            await newDog.save();
            return res.status(201).json({error: false, message: `El perrito ${name} ha sido creado con éxito`})

        } catch (err) {
            return res.status(400).json(err);
        }
    },

    createDogCrud: async (req, res) => {
        console.log(req.body)
        const { name, breed, color, weight, birth, size, female, sterilized } = req.body; 
        try {
            const newDog = new Dog({
                name : name,
                breed: breed,
                color: color,
                weight: weight,
                birth: birth,
                size: size,
                female: female,
                sterilized: sterilized
            });
            
            await newDog.save();
            res.redirect('./perros');
            
        } catch (err) {
            return res.status(400).json(err);
        }
    },

    editDog: async (req, res) => {
        const { dog } = req.params;
        try {
            const current = await Dog.findOne({ _id : dog });
            return res.render('editar-perro', { title: 'Editar perro', current: current });
        } catch (err) {
            return res.status(400).json(err);
        }
    },
    
    updateDog: async (req, res) => {
        const { dog } = req.params;
        console.log(req.body)
        const { name, breed, color, weight, birth, size, female, sterilized } = req.body; 
        try {
            await Dog.updateOne({ _id: dog }, {name: name, breed: breed, color: color, weight: weight, 
            birth: birth, size: size, female: female, sterilized: sterilized});
            res.redirect('/perros');
        } catch (err) {
            return res.status(400).json(err);
        }
    },

    update: async (req, res) => {
        const {_id,name, breed, female, weight, color, birth, sterilized} = req.body;
        try {
            await Dog.updateOne({_id: _id}, {name:name, breed: breed, female: female, 
                weight: weight, color: color, birth: birth, sterilized: sterilized});
            
            return res.status(200).json({error: false, message: `El perrito ${name} ha sido actualizado con éxito`});
        } catch (err) {
            return res.status(400).json(err);
        }
    },

    findAll: async(req, res) => {
        try{
            const dogs = await Dog.find({});
            return res.status(200).json({error: false, perros: dogs});
        }
        catch(err){
            return res.status(400).json(err);
        }
    },

    findAllCrud: async(req, res) => {
        try{
            const dogs = await Dog.find({});
            res.render('perros', { title: 'Perros Life Dog', perros: dogs });
        }
        catch(err){
            return res.status(400).json(err);
        }
    },

    deleteDog: async(req, res) => {
        try {
            const { dog } = req.params;
            await Dog.deleteOne({ _id : dog });
            res.redirect('/perros')
        }
        catch(err){
            return res.status(400).json(err);
        }
    }
};

module.exports = DogController
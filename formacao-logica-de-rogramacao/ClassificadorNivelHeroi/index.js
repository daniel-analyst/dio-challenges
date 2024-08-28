const heroXp = 2500;
const nameHero = 'SuperMan';
let nivel = '';

if (heroXp <= 1000) {
    nivel = 'Ferro';
} else if (heroXp > 1000 && heroXp <= 2000) {
    nivel = 'Bronze';
} else if (heroXp > 2000 && heroXp <= 5000) {
    nivel = 'Prata';
} else if (heroXp > 5000 && heroXp <= 7000) {
    nivel = 'Ouro';
} else if (heroXp > 7000 && heroXp <= 8000) {
    nivel = 'Platina';
} else if (heroXp > 8000 && heroXp <= 9000) {
    nivel = 'Ascendente';
} else if (heroXp > 9000 && heroXp <= 10000) {
    nivel = 'Imortal';
} else if (heroXp > 10000) {
    nivel = 'Radiante';
}

console.log('O Herói de nome **' + nameHero +'** está no nível de **' + nivel + '**');
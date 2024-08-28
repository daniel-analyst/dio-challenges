let ranque = '';
const saldo = calcularSaldoVitorias(100, 40);

if (saldo <= 10) {
    ranque = 'Ferro';
} else if (saldo > 10 && saldo <= 20) {
    ranque = 'Bronze';
} else if (saldo > 20 && saldo <= 50) {
    ranque = 'Prata';
} else if (saldo > 50 && saldo <= 80) {
    ranque = 'Ouro';
} else if (saldo > 80 && saldo <= 90) {
    ranque = 'Diamante';
} else if (saldo > 90 && saldo <= 100) {
    ranque = 'Lendário';
} else if (saldo > 100) {
    ranque = 'Imortal';
}

console.log('O Herói tem de saldo de **' + saldo + '** está no nível de **' + ranque + '**');

function calcularSaldoVitorias(quantidadeVitoria, quantidadeDerrota) {
    return quantidadeVitoria - quantidadeDerrota;
}
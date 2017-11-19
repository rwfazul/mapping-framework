var palestras    = [ ];
var num_palestra = 0;

var Palestrante = function(nome, sexo, grauAcademico, cursoFormacao, instituicaoFormacao) {
    this.nome = nome;
    this.sexo = sexo;
    this.grauAcademico = grauAcademico;
    this.cursoFormacao = cursoFormacao; 
    this.instituicaoFormacao = instituicaoFormacao;
};

var Sala = function(nome, publicoPrevisto) {
    this.nome = nome;
    this.publicoPrevisto = publicoPrevisto;
};

var Palestra = function(num_palestra, titulo, assunto, descricao, data, inicio, fim, sala, palestrante) {
    this.num_palestra = num_palestra;
    this.titulo = titulo;
    this.assunto = assunto;
    this.descricao = descricao;
    this.data = data;
    this.inicio = inicio;
    this.fim = fim;
    this.sala = sala;
    this.palestrante = palestrante;
};

var Predio = function(nome) {
    this.nome = nome;
};

var Evento = function(nome, descricao, endereco, dataInicio, dataFim, predio, palestras) {
    this.nome = nome;
    this.descricao = descricao;
    this.endereco = endereco;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.predio = predio;
    this.palestras = palestras;
};

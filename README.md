<h1>Addressfinder(Buscador de Endereços)</h1>
<h2>Projeto iniciado, a partir de um desafio da foarmação(Aprenda a programar em Java com Orientação a Objetos) da Alura, onde consiste em consumir uma API para consultar CEPs,
fui indicado a utilizar a API ViaCEP, e usar o retorno dessa API para criar um arquivo, com todos os CEPs buscados.</h2>
<h1>Funcionamento</h1>
<p>Addresfinder é uma aplicação via console, onde o programa de faz perguntas e o usuário responde conforme o programa vai se desenvolvendo, consiste em o usuário digitar um número
de CEP váilido (com 8 carácteres), e o programa irá fazer um requsição HTTP para a API do ViaCEP, caso o CEP exista, o usuário receberá uma mensagem no console "CEP buscado com sucesso"
e caso o CEP não exista "CEP não encontrado", caso o usuário digite um número de CEP inválido, o programa não irá aceitar e logo em seguida pede para digitar um núnero válido, ao término
do programa você pode escolher buscar outro CEP ou não, caso escolha não o programa encerra e grava todos os CEPs buscados em um arquivo .json</p>
<h1>Ferramentas Utilizadas:</h1>
<P>Foram utilizados neste projeto: a API do ViaCEP, usada para consultar os CEPs, a biblioteca do Google chamada GSON, que foi utilizada para converter o JSON da API para um objeto Java
onde podemos manipular esse objeto, e também utilizamos para poder transformar de volta o objeto Java em um JSON para armazena-lo em um arquivo, realizando a Serialização e Desserialização
destes dados, também utilizamos as bibliotecas do Java como: java.io, java.security, java.util e java.net, para abrir e fechar arquivos, fazer verificações, usar classes de arrays como
a ArrayList e classes de entrada de dados como a Scanner, e fazer requisições a API.</P>
<h1>Como usar:</h1>
<p>Para fazer a utilização do código você precisará de um editor de códigos, neste caso eu usei o IntelliJ IDEA, basta ir até a classe main e usar o atalho "SHIFT" + F10 para iniciar o 
programa e ir respndendo as pergutas do console:</p>



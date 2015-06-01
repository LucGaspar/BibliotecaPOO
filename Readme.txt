Compilação:
	javac Aluno.java Biblioteca.java Comunidade.java Emprestimo.java Geral.java Livro.java LivroPadrao.java Professor.java Sistema.java Texto.java Usuario.java UsuarioPadrao.java

Execução pelo class:
	java Biblioteca.class StringCsvDoProfessor StringCsvDoAluno StringCsvDaComunidade StringCsvDeTexto StringCsvGeral
    Exemplo: java Biblioteca.class Professor.csv Aluno.csv Comunidade.csv Texto.csv Geral.csv
    Observação: não é necessária a existência prévia dos arquivos dados como argumentos

Execução pelo jar:
	java -jar Biblioteca.jar StringCsvDoProfessor StringCsvDoAluno StringCsvDaComunidade StringCsvDeTexto StringCsvGeral
    Exemplo: java -jar Biblioteca.jar Biblioteca.class Professor.csv Aluno.csv Comunidade.csv Texto.csv Geral.csv

Funcionamento: todo em linha de comando, há um menu principal e os secundários, sendo estes alcançáveis pelo primeiro. Basta escolher as opções desejadas e depois fornecer os dados requeridos. É válido denotar que o formato da hora é em dd/mm/yyyy e que a viagem no tempo está disponível ao escolher a opção 7 do menu inicial.
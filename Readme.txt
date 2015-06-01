Compila��o:
	javac Aluno.java Biblioteca.java Comunidade.java Emprestimo.java Geral.java Livro.java LivroPadrao.java Professor.java Sistema.java Texto.java Usuario.java UsuarioPadrao.java

Execu��o pelo class:
	java Biblioteca.class StringCsvDoProfessor StringCsvDoAluno StringCsvDaComunidade StringCsvDeTexto StringCsvGeral
    Exemplo: java Biblioteca.class Professor.csv Aluno.csv Comunidade.csv Texto.csv Geral.csv
    Observa��o: n�o � necess�ria a exist�ncia pr�via dos arquivos dados como argumentos

Execu��o pelo jar:
	java -jar Biblioteca.jar StringCsvDoProfessor StringCsvDoAluno StringCsvDaComunidade StringCsvDeTexto StringCsvGeral
    Exemplo: java -jar Biblioteca.jar Biblioteca.class Professor.csv Aluno.csv Comunidade.csv Texto.csv Geral.csv

Funcionamento: todo em linha de comando, h� um menu principal e os secund�rios, sendo estes alcan��veis pelo primeiro. Basta escolher as op��es desejadas e depois fornecer os dados requeridos. � v�lido denotar que o formato da hora � em dd/mm/yyyy e que a viagem no tempo est� dispon�vel ao escolher a op��o 7 do menu inicial.
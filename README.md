# Ewig

Para o funcionamento correto do sistema, deve ser feito a importação do driver do jdbc para PostgreSQL e da biblioteca itext, que podem ser encontradas em resources/bibliotecas.

Também é necessário a criação de um banco de dados PostgreSQL com o nome Ewig e com usuario postgres, onde deve ser feito o backup por meio do arquivo de backup encontrado em resources/backup.

Deve ser adicionada a senha do pgadmin no atributo "senha" existente na linha 11 do arquivo src/Ewig/model/DAO/BaseDAO.java.

Por fim, o arquivo a ser executado é src/Ewig/view/Telas.java.

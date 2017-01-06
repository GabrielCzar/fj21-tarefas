Passos para fazer deploy da aplicacao em ambiente de producao

obs.: utilizando como servidor o Tomcat, que deve estar no ar

1. Criacao:  
- Clique com o botao direito no projeto e va em EXPORT -> WAR file  
	- Aparecera uma configuracoes sobre o WAR export   
- Clique no botao BROWSER e escolha o local de destino  
- Clique em  FINISH e nosso WAR estara criado  
  
2. Instalacao:  
- Abra o gerenciador de arquivos no local do .WAR
- Certifique que o TOMCAT esteja rodando
- Recorte o arquivo
- Cole o arquivo no diretorio WEBAPPS do APACHE-TOMCAT
- Pronto, agora so acessar a aplicacao
- http://localhost:8080/nome_war_file

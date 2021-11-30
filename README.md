# API Crud de Funcionários
A aplicação utiliza uma conexão com postgres, logo, será necessário que uma instância esteja rodando para o deploy do projeto.  
  
Comando para criação do container: **docker run --name postgres-funcionario -e POSTGRES_PASSWORD=12345 -p 5447:5432 -d postgres**


# Endpoints 
	
## Criar
@POST /api/v1/funcionario/criar  
  
Payload:   
{  
   "nome": "HIGOR",  
   "sobrenome": "LAURIANO",  
   "email": "higor.lauriano@gmail.com",  
   "numeroNIS": "12345"  
}

Retorno:
{  
   "id": 1,  
   "nome": "HIGOR",  
   "sobrenome": "LAURIANO",  
   "email": "higor.lauriano@gmail.com",  
   "numeroNIS": "12345"  
}

## Consultar
@GET /api/v1/funcionario/{id}

Retorno:
{  
   "id": 1,  
   "nome": "HIGOR",  
   "sobrenome": "LAURIANO",  
   "email": "higor.lauriano@gmail.com",  
   "numeroNIS": "12345"  
}

## Atualizar
@PATCH /api/v1/funcionario/atualizar/{id}  
  
Payload:   
{  
   "nome": "HIGOR",  
   "sobrenome": "LAURIANO",  
   "email": "higor.lauriano@gmail.com",  
   "numeroNIS": "12345"  
}

Retorno:
{  
   "id": 1,  
   "nome": "HIGOR",  
   "sobrenome": "LAURIANO",  
   "email": "higor.lauriano@gmail.com",  
   "numeroNIS": "12345"  
}

## Remover
@DELETE /api/v1/funcionario/remover/{id}

## Listar
@GET /api/v1/funcionario/listar
  
[
	{  
	 "id": 1,
	  "nome": "HIGOR", 
	  "sobrenome": "LAURIANO", 
	  "email": "higor.lauriano@gmail.com", 
	  "numeroNIS": "12345"
	  }  
]
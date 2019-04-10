/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sinoa
 * Created: Apr 9, 2019
 */
DROP TABLE IF EXISTS "book_page";
DROP TABLE IF EXISTS "book";

CREATE TABLE IF NOT EXISTS "book" (
	"id" serial NOT NULL,
	"title" varchar(100) NOT NULL UNIQUE,
	"description" TEXT NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	"author" varchar(100) NOT NULL,
	"total_pages" integer NOT NULL,
	"issue_date" TIMESTAMP NOT NULL,
	CONSTRAINT book_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE IF NOT EXISTS "book_page" (
	"id_book" bigint NOT NULL,
	"content" TEXT NOT NULL,
	"page_number" integer NOT NULL,
	CONSTRAINT book_page_pk PRIMARY KEY ("id_book","page_number")
) WITH (
  OIDS=FALSE
);



ALTER TABLE  "book_page" ADD CONSTRAINT  "book_page_fk0" FOREIGN KEY ("id_book") REFERENCES "book"("id");
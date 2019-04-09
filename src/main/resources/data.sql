/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sinoa
 * Created: Apr 9, 2019
 */



INSERT INTO public.book(
	id , author, created_at, description, issue_date, title, total_pages, updated_at)
	VALUES (1,'Aditi Das Bhowmik', Current_timestamp, 'A short fictional story of two friends held in the claws of a ravaging earthquake.',
			Current_timestamp, 'Friends Forever', 5, Current_timestamp);

		
INSERT INTO public.book_page( content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Page 1', 1, 1);


INSERT INTO public.book_page( content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Page 2', 2, 1);


INSERT INTO public.book_page(content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Page 3', 3, 1);

INSERT INTO public.book_page( content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Page 4', 4, 1);



INSERT INTO public.book_page( content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Page 5', 5, 1);




INSERT INTO public.book(
	id , author, created_at, description, issue_date, title, total_pages, updated_at)
	VALUES (2,'Katie Such', Current_timestamp, 'Elissa has always been cold hearted. When boys get klingy she used to push them away. When she doesnt want a guy anymore she drops them like hot rocks. up until she meets Aiden and everything changes. But an unexpected surprise happens between the couple and they will never be the same.',
			Current_timestamp, 'My Sophomore Year', 3, Current_timestamp);

INSERT INTO public.book_page( content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Page 1', 1, 2);

INSERT INTO public.book_page( content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Page 2', 2, 2);

INSERT INTO public.book_page( content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Page 3', 3, 2);


INSERT INTO public.book(
	id , author, created_at, description, issue_date, title, total_pages, updated_at)
	VALUES (3,'William Shakespeare', Current_timestamp, 'Secrets are a dangerous thing, especially when an entire relationship is based off one, big, destructive secret. The young, successful, forward-thinking, Olivia Reinbeck, falls for an older man, the alluring Callem Tate. Together, they grow into a luxurious lifestyle than',
			Current_timestamp, 'Romeo and Juliet', 2, Current_timestamp);


INSERT INTO public.book_page( content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Page 1', 1, 3);

INSERT INTO public.book_page( content, page_number, id_book)
	VALUES ( 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry is standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Page 2', 2, 3);


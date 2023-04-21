
Create database JAVA_CSDL
use JAVA_CSDL
CREATE TABLE Student (
    Id int NOT NULL,
    Name Nvarchar(64) NOT NULL,
    BirthDay date NOT NULL,
    Address Nvarchar(64) NOT NULL,
    Gender bit NOT NULL,
    PRIMARY KEY (Id)
);
INSERT INTO Student (Id, Name, BirthDay, Address, Gender) VALUES (N'1', N'Nguyễn Thị Lê', N'2003-12-23', N'Quảng Nam', 1);
INSERT INTO Student (Id, Name, BirthDay, Address, Gender) VALUES (N'2', N'Trần Văn Nguyên', N'2003-02-24', N'Quảng Bình', 0);
INSERT INTO Student (Id, Name, BirthDay, Address, Gender) VALUES (N'3', N'Văn Thị Bạch Dương', N'2003-01-14', N'Huế', 1);

CREATE TABLE Table1 (
    Id int NOT NULL,
    Name Nvarchar(64) NOT NULL,
    Address Nvarchar(64) NOT NULL,
    Total float NOT NULL,
    PRIMARY KEY (Id)
);

INSERT INTO Table1 (Id, Name,  Address, Total) VALUES (N'1', N'Nguyễn Thị Lê',  N'Quảng Nam', 15.6);
INSERT INTO Table1 (Id, Name,  Address, Total) VALUES (N'2', N'Trần Văn Nguyên',  N'Quảng Bình', 30.4);
INSERT INTO Table1 (Id, Name,  Address, Total) VALUES (N'3', N'Văn Thị Bạch Dương',  N'Huế', 10.7);

select * from Student
select * from Table1
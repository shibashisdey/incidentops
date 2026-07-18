# IncidentOps Development Guide

## Project Overview

IncidentOps is an enterprise-grade Incident Management System built to demonstrate production-quality backend engineering.

---

# Technology Stack

- Java 21
- Spring Boot 4.x
- Maven
- PostgreSQL
- Spring Data JPA
- Spring Security
- Lombok
- Jakarta Validation

---

# Architecture

Architecture Style:
- Modular Monolith

Architecture Pattern:
- Layered Architecture

API Style:
- REST

Package Strategy:
- Domain Driven

Every feature belongs to its own module.

Example:

com.incidentops.incidentops

    auth
    user
    ticket
    comment
    attachment
    notification

    common
    config
    security
    exception

Never create random packages.

---

# Common Package

Only reusable framework-level code belongs here.

common

    response
    entity
    constants
    util
    validation
    mapper

Current decisions:

response
- ApiResponse<T>

entity
- BaseEntity
- contains only audit fields
- NO id field

mapper
- reserved for future
- do not introduce abstractions until duplication appears

util
- keep minimal
- DateTimeUtil
- UuidUtil

validation
- reusable validation annotations only

constants
- introduce only when genuinely needed

Never place business logic inside common.

---

# Layering

Each domain module follows:

module

    controller
    service
    service.impl
    repository
    entity
    dto
    mapper
    enums

Never skip layers.

Controllers never access repositories.

Repositories never contain business logic.

---

# Controllers

Controllers must:

- remain thin
- validate requests
- call services only

Return:

ResponseEntity<ApiResponse<T>>

Never return entities.

Never contain business logic.

---

# Services

Business logic belongs only here.

Services:

- validate rules
- coordinate repositories
- call mappers
- throw exceptions
- return DTOs

Never expose entities.

---

# Repositories

Repositories only perform persistence.

No business logic.

---

# Entities

Rules:

- @Entity
- Lombok
- LAZY relationships by default
- each entity owns its own primary key

Audit fields come from BaseEntity.

Never expose entities directly through APIs.

---

# DTOs

Every module owns its own DTOs.

Examples:

user.dto

ticket.dto

auth.dto

Never create common.dto.

---

# Exceptions

Use GlobalExceptionHandler.

Never write try/catch inside controllers.

Throw meaningful exceptions.

---

# API Response Format

Every endpoint returns:

ApiResponse<T>

Example Success

{
  "success": true,
  "message": "...",
  "data": { }
}

Example Failure

{
  "success": false,
  "message": "...",
  "data": null
}

---

# Validation

Use Jakarta Validation.

Examples:

@NotBlank

@NotNull

@Email

@Size

Validation belongs in DTOs.

Reusable validators belong in:

common.validation

---

# Dependency Injection

Constructor Injection only.

Never use field injection.

---

# Logging

Use SLF4J.

Never use:

System.out.println()

---

# Mapping

Each module owns its mapper.

Example:

user.mapper.UserMapper

Do not introduce BaseMapper until real duplication exists.

Follow the Rule of Three.

---

# Naming

Classes

PascalCase

Methods

verbNoun()

Examples:

createTicket()

assignUser()

closeIncident()

Variables

camelCase

Constants

UPPER_CASE

---

# Utilities

Utility classes must be:

- stateless
- generic
- reusable

Never place business rules inside utilities.

---

# Constants

Only create constants when repeated in multiple places.

Do not create speculative constants.

Never store:

- passwords
- JWT secrets
- API keys
- database credentials

Configuration belongs in application.yml.

---

# Security

Never hardcode:

Secrets

Passwords

Tokens

Keys

Everything must come from configuration.

---

# Code Quality

Keep methods short.

Prefer readability over cleverness.

Follow:

- SOLID
- DRY
- Single Responsibility Principle

Avoid unnecessary abstraction.

Use abstraction only after repeated patterns emerge.

---

# Git

One logical feature per commit.

Avoid unrelated changes.

Do not refactor code outside the requested task.

---

# Codex Workflow

For every task:

1. Read this guide.
2. Implement only the requested step.
3. Do not modify unrelated files.
4. Explain every change after implementation.
5. Wait for review before continuing.

Never implement multiple milestones in one step.

Never invent architecture.

Always preserve existing project conventions.
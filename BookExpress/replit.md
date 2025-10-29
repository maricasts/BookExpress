# Overview

Dicarta Livraria is a bookstore management system with a dual-role architecture supporting both customers and technicians. The system provides a complete digital bookstore solution with inventory management, order processing, and user role-based access control. Customers can browse catalogs, manage shopping carts, and place orders, while technicians can manage book inventory, handle service orders, and oversee system operations.

# User Preferences

Preferred communication style: Simple, everyday language.

# System Architecture

## Application Architecture
The application is built as a monolithic Flask web application with server-side rendering:

- **Flask Application**: Full-stack web framework handling both presentation and business logic
- **Template Structure**: Jinja2 templates with a base layout and role-specific dashboards
- **Styling**: Dark theme Bootstrap with custom CSS enhancements and Font Awesome icons
- **Client-side Logic**: Minimal JavaScript for form handling, modal interactions, and UI enhancements
- **Responsive Design**: Mobile-first approach using Bootstrap grid system
- **Session Management**: Flask sessions for user authentication, state, and shopping cart persistence
- **Database**: PostgreSQL with SQLAlchemy ORM for data persistence
- **Deployment**: Runs on port 5000 with 0.0.0.0 binding for Replit environment

## Data Models
The system manages four core entities:
- **Cliente**: Customer information with personal and contact details
- **Tecnico**: Technical staff with employment details and hourly rates
- **Livro**: Book catalog with pricing, inventory, and metadata
- **OrdemDeServico**: Service orders for business operations tracking

## Authentication & Authorization
Role-based access control with two distinct user types:
- **Cliente**: Access to catalog browsing, shopping cart, and order placement
- **Tecnico**: Administrative access to inventory management and service order processing
- Session-based authentication with role persistence

## Business Logic Patterns
- **Shopping Cart**: Session-based cart management with add/remove functionality
- **Inventory Control**: Real-time stock tracking and management
- **Order Processing**: Service order lifecycle management with status tracking
- **Data Validation**: Form validation on both client and server sides

# External Dependencies

## Database
- **PostgreSQL Database**: Primary data persistence layer (via Replit's built-in PostgreSQL)
- **SQLAlchemy**: Python ORM for database operations and migrations
- **Flask-SQLAlchemy**: Flask extension for SQLAlchemy integration

## Frontend Libraries
- **Bootstrap**: UI framework with dark theme support
- **Font Awesome**: Icon library for enhanced user interface
- **jQuery/JavaScript**: Client-side interactivity and form handling

## Infrastructure
- **Flask**: Python web framework for full-stack web application
- **Werkzeug**: WSGI utilities and proxy handling for Replit environment
- **Gunicorn**: Production WSGI server for deployment
- **Psycopg2**: PostgreSQL adapter for Python
- **Session Storage**: Flask built-in session management

## Development Tools
- **Python 3.11+**: Primary programming language
- **uv**: Modern Python package manager
- **Jinja2**: Template engine for dynamic content rendering
- **CSS3**: Custom styling and responsive design enhancements
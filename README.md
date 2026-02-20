# OmniHome Smart System Integration – Lab 1

## Overview

OmniHome is a modular smart home backend system designed to manage diverse smart devices, legacy hardware, and automation routines.

Design patterns implemented:
- Singleton
- Abstract Factory
- Adapter
- Builder
- Prototype
- Factory Method (implicit within Abstract Factory)

The system simulates a smart home hub capable of connecting to a cloud service, deploying different device families, integrating legacy hardware, cloning configurations efficiently, and executing automation routines.

---

## UML Diagram

The UML diagram illustrates the relationships between interfaces, concrete device implementations, factories, adapters, configurations, and automation routines.
It was produced by IntelliJ IDEA.

![UML Diagram](assets/UML_Diagram.png)

The diagram shows:

- Inheritance hierarchy of smart devices
- Interface implementations for SmartLight, SmartThermostat, and SmartLock
- Abstract Factory structure creating Budget and Luxury device families
- Adapter relationship linking GlorbAdapter with GlorbThermostat
- Singleton cloud connection with single instance control
- Builder-created AutomationRoutine
- Prototype-based DeviceConfiguration cloning

---

## Project Structure

```text
Lab1/
│
├── OmniHome/
│   ├── automation/
│   │   └── AutomationRoutine.java
│   │
│   ├── config/
│   │   └── DeviceConfiguration.java
│   │
│   ├── connection/
│   │   └── CloudConnection.java
│   │
│   ├── devices/
│   │   ├── LuxuryLight.java
│   │   ├── BudgetLight.java
│   │   ├── LuxuryThermostat.java
│   │   ├── BudgetThermostat.java
│   │   ├── LuxuryLock.java
│   │   └── BudgetLock.java
│   │
│   ├── factories/
│   │   ├── SmartHomeFactory.java
│   │   ├── LuxuryHomeFactory.java
│   │   └── BudgetHomeFactory.java
│   │
│   ├── interfaces/
│   │   ├── SmartDevice.java
│   │   ├── SmartLight.java
│   │   ├── SmartThermostat.java
│   │   └── SmartLock.java
│   │
│   ├── legacy/
│   │   ├── GlorbThermostat.java
│   │   └── GlorbAdapter.java
│   │
│   ├── test/
│   │   ├── AdapterTest.java
│   │   ├── CloudConnectionTest.java
│   │   ├── FactoryTest.java
│   │   └── PatternsTest.java
│   │
│   └── Main.java
│
├── assets/
│   └── UML_Diagram.png
│
├── .gitignore
└── README.md
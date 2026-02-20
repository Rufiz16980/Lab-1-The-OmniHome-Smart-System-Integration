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
- Interface implementations
- Abstract Factory structure
- Adapter relationship with legacy device
- Singleton cloud connection
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
│   │   └── BudgetThermostat.java
│   │
│   ├── factories/
│   │   ├── SmartHomeFactory.java
│   │   ├── LuxuryHomeFactory.java
│   │   └── BudgetHomeFactory.java
│   │
│   ├── interfaces/
│   │   ├── SmartDevice.java
│   │   ├── SmartLight.java
│   │   └── SmartThermostat.java
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
```

---

[//]: # ()
[//]: # ()
[//]: # (## Design Pattern Implementations)

[//]: # ()
[//]: # (### 1. Singleton Pattern – CloudConnection)

[//]: # ()
[//]: # (**Class:** `connection/CloudConnection.java`)

[//]: # ()
[//]: # (**Purpose:** Ensures that only one cloud connection exists throughout the system.)

[//]: # ()
[//]: # (**Key Characteristics:**)

[//]: # ()
[//]: # (- Private static instance field)

[//]: # (- Private constructor)

[//]: # (- Public static `getInstance&#40;&#41;` method)

[//]: # (- Thread-safe using double-checked locking)

[//]: # ()
[//]: # (**Usage Example:**)

[//]: # ()
[//]: # (```java)

[//]: # (CloudConnection cloud = CloudConnection.getInstance&#40;&#41;;)

[//]: # (cloud.sendData&#40;"System Initialized"&#41;;)

[//]: # (```)

[//]: # ()
[//]: # (**Benefit:** Prevents multiple conflicting cloud connections.)

[//]: # ()
[//]: # (### 2. Abstract Factory Pattern – Device Families)

[//]: # ()
[//]: # (**Classes:** - `factories/SmartHomeFactory.java`)

[//]: # (- `factories/LuxuryHomeFactory.java`)

[//]: # (- `factories/BudgetHomeFactory.java`)

[//]: # ()
[//]: # (**Purpose:** Creates families of related devices &#40;Luxury or Budget&#41; without specifying concrete classes.)

[//]: # ()
[//]: # (**Product Families:**)

[//]: # ()
[//]: # (- **Luxury:**)

[//]: # (    - `LuxuryLight`)

[//]: # (    - `LuxuryThermostat`)

[//]: # (- **Budget:**)

[//]: # (    - `BudgetLight`)

[//]: # (    - `BudgetThermostat`)

[//]: # ()
[//]: # (**Usage Example:**)

[//]: # ()
[//]: # (```java)

[//]: # (SmartHomeFactory factory = new LuxuryHomeFactory&#40;&#41;;)

[//]: # (SmartLight light = factory.createSmartLight&#40;&#41;;)

[//]: # (SmartThermostat thermostat = factory.createSmartThermostat&#40;&#41;;)

[//]: # (```)

[//]: # ()
[//]: # (**Benefit:** Allows easy switching between product families.)

[//]: # ()
[//]: # (### 3. Adapter Pattern – Legacy Thermostat Integration)

[//]: # ()
[//]: # (**Classes:** - `legacy/GlorbThermostat.java`)

[//]: # (- `legacy/GlorbAdapter.java`)

[//]: # ()
[//]: # (**Problem:** `GlorbThermostat` uses:)

[//]: # (- Fahrenheit instead of Celsius)

[//]: # (- Integer instead of double)

[//]: # (- Different interface)

[//]: # ()
[//]: # (**Solution:** `GlorbAdapter` converts modern interface calls into legacy-compatible calls.)

[//]: # ()
[//]: # (**Usage Example:**)

[//]: # ()
[//]: # (```java)

[//]: # (GlorbThermostat legacy = new GlorbThermostat&#40;&#41;;)

[//]: # (SmartDevice adapter = new GlorbAdapter&#40;"GLORB-01", legacy&#41;;)

[//]: # ()
[//]: # (&#40;&#40;SmartThermostat&#41; adapter&#41;.setTemperature&#40;22.5&#41;;)

[//]: # (```)

[//]: # ()
[//]: # (**Benefit:** Allows legacy hardware to work seamlessly with modern system.)

[//]: # ()
[//]: # (### 4. Builder Pattern – Automation Routine Construction)

[//]: # ()
[//]: # (**Class:** `automation/AutomationRoutine.java`)

[//]: # ()
[//]: # (**Purpose:** Construct complex `AutomationRoutine` objects step-by-step.)

[//]: # ()
[//]: # (**Features:**)

[//]: # ()
[//]: # (- Required parameter: name)

[//]: # (- Optional parameters: schedule time, repeat, devices)

[//]: # (- Validation before creation)

[//]: # ()
[//]: # (**Usage Example:**)

[//]: # ()
[//]: # (```java)

[//]: # (AutomationRoutine routine =)

[//]: # (    new AutomationRoutine.RoutineBuilder&#40;"Morning Wake Up"&#41;)

[//]: # (        .atTime&#40;"07:00"&#41;)

[//]: # (        .addDevice&#40;light&#41;)

[//]: # (        .addDevice&#40;thermostat&#41;)

[//]: # (        .setRepeat&#40;true&#41;)

[//]: # (        .build&#40;&#41;;)

[//]: # (```)

[//]: # ()
[//]: # (**Benefit:** Avoids complex constructors and allows flexible object creation.)

[//]: # ()
[//]: # (### 5. Prototype Pattern – Configuration Cloning)

[//]: # ()
[//]: # (**Class:** `config/DeviceConfiguration.java`)

[//]: # ()
[//]: # (**Purpose:** Allows fast duplication of existing configurations instead of creating from scratch.)

[//]: # ()
[//]: # (**Key Method:**)

[//]: # ()
[//]: # (```java)

[//]: # (DeviceConfiguration clone = masterConfig.clone&#40;&#41;;)

[//]: # (```)

[//]: # ()
[//]: # (**Benefit:**)

[//]: # (- Faster than full initialization)

[//]: # (- Independent copy)

[//]: # (- Efficient configuration reuse)

[//]: # ()
[//]: # (### 6. Factory Method Pattern – Implicit)

[//]: # ()
[//]: # (Factory methods exist inside:)

[//]: # (- `LuxuryHomeFactory`)

[//]: # (- `BudgetHomeFactory`)

[//]: # ()
[//]: # (**Methods:**)

[//]: # (- `createSmartLight&#40;&#41;`)

[//]: # (- `createSmartThermostat&#40;&#41;`)

[//]: # ()
[//]: # (These methods encapsulate object creation logic.)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (## Unit Testing)

[//]: # ()
[//]: # (All patterns are verified using JUnit 5 tests located in:  )

[//]: # (`OmniHome/test/`)

[//]: # ()
[//]: # (**Test Classes:**)

[//]: # ()
[//]: # (| Test Class | Verifies |)

[//]: # (| :--- | :--- |)

[//]: # (| `CloudConnectionTest` | Singleton uniqueness |)

[//]: # (| `AdapterTest` | Adapter temperature conversion |)

[//]: # (| `FactoryTest` | Correct device creation |)

[//]: # (| `PatternsTest` | Builder and Prototype |)

[//]: # ()
[//]: # (**Example assertion:**)

[//]: # ()
[//]: # (```java)

[//]: # (assertSame&#40;conn1, conn2&#41;;)

[//]: # (```)

[//]: # ()
[//]: # (Confirms Singleton behavior.)

[//]: # ()
[//]: # (---)

[//]: # ()
[//]: # (## Main Execution Flow)

[//]: # ()
[//]: # (**File:** `OmniHome/Main.java`)

[//]: # ()
[//]: # (**Execution sequence:**)

[//]: # ()
[//]: # (1. Establish Singleton cloud connection)

[//]: # (2. Create master configuration and clone it &#40;Prototype&#41;)

[//]: # (3. Deploy devices using Abstract Factory)

[//]: # (4. Integrate legacy thermostat using Adapter)

[//]: # (5. Construct automation routine using Builder)

[//]: # (6. Execute routine)

[//]: # (7. Manually control devices)
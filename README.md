# MOBILE-2

## Emission Calculation Project

This Kotlin project calculates emission factors and gross emissions for different fuel types including coal, fuel oil, and natural gas.

## Features

- Calculate emission factors based on fuel parameters
- Compute gross emissions for different fuel types
- Proper logging system with timestamps and log levels
- Support for coal, fuel oil (mazut), and natural gas calculations

## Usage

Run the main function to calculate emissions for Variant 3 parameters:

```bash
kotlin MainKt
```

## Output

The program outputs emission calculations with proper logging format including:

- Coal emission factor and gross emission
- Fuel oil emission factor and gross emission  
- Natural gas emission factor and gross emission
- Total gross emission

## Project Structure

```text
src/
├── main/
│   └── kotlin/
│       └── Main.kt          # Main calculation logic
└── test/
    └── kotlin/              # Test files (if any)
```

## Dependencies

- Kotlin Standard Library
- Java Util Logging

## Author

Created for mobile development course project.
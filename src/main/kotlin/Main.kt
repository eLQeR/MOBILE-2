fun calculateEmissionFactor(Qri: Double, Ar: Double, aVin: Double, etaZu: Double, GVin: Double): Double {
    return (1000000.0 / Qri) * (Ar / 100.0) * aVin * (1 - etaZu) / (1 - GVin / 100.0)
}

fun calculateGrossEmission(k: Double, B: Double, Qri: Double): Double {
    return k * B * Qri / 1000000.0
}

fun main() {
    // Constants
    val etaZu = 0.985 // Efficiency of dust collection

    // Coal parameters (Variant 3 from Table 2.4)
    val BCoal = 759834.56 // tons
    val QriCoal = 20.47 // MJ/kg
    val ArCoal = 25.20 / 100.0 // Ash content, fraction
    val aVinCoal = 0.80 // Volatile ash fraction for coal with liquid slag removal
    val GVinCoal = 1.5 / 100.0 // Combustible in volatile ash, fraction

    // Fuel oil parameters (Variant 3 from Table 2.4)
    val BMazut = 99672.62 // tons
    val QriMazut = 39.48 // MJ/kg (derived from document)
    val ArMazut = 0.15 / 100.0 // Ash content, fraction
    val aVinMazut = 1.0 // Volatile ash fraction for mazut
    val GVinMazut = 0.0 / 100.0 // Combustible in volatile ash, fraction

    // Natural gas emission factor (assumed 0 as no solid particles)
    val kGas = 0.0

    // Calculate emission factors
    val kCoal = calculateEmissionFactor(QriCoal, ArCoal, aVinCoal, etaZu, GVinCoal)
    val kMazut = calculateEmissionFactor(QriMazut, ArMazut, aVinMazut, etaZu, GVinMazut)

    // Calculate gross emissions
    val EGrossCoal = calculateGrossEmission(kCoal, BCoal, QriCoal)
    val EGrossMazut = calculateGrossEmission(kMazut, BMazut, QriMazut)
    val EGrossGas = 0.0 // No emission from gas

    // Total gross emission
    val totalEGross = EGrossCoal + EGrossMazut + EGrossGas

    // Output results
    println("Emission results for Variant 3:")
    println("Coal emission factor: %.2f g/GJ".format(kCoal))
    println("Coal gross emission: %.2f tons".format(EGrossCoal))
    println("Fuel oil emission factor: %.2f g/GJ".format(kMazut))
    println("Fuel oil gross emission: %.2f tons".format(EGrossMazut))
    println("Natural gas emission factor: %.2f g/GJ".format(kGas))
    println("Natural gas gross emission: %.2f tons".format(EGrossGas))
    println("Total gross emission: %.2f tons".format(totalEGross))
}
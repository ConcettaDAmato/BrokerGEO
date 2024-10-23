# BrokerGEO
BrokerGEO is a Java-based component within the GEOframe system that acts as a coupler, allowing different models, such as WHETGEO and GEOET, to exchange data dynamically. Its primary role is to split evaporation (Es) and transpiration (El) between the control volumes in which the soil column is discretised, ensuring mass and energy balance within the soil column.

BrokerGEO facilitates the interaction between ET and water flow models by implementing different methods to split ET based on soil, water and root characteristics. This partitioning is critical for understanding how water is distributed between plant roots and soil surfaces under varying environmental conditions.

The methods used by BrokerGEO for partitioning ET include:

- _AverageWaterWeightedMethod_: Distributes the reference ET (ETref) based on an average of water stress factors across all soil layers.
- _SizeWaterWeightedMethod_: Distributes ETref proportionally to the size of the control volumes in the soil.
- _RootWaterWeightedMethod_: Distributes ETref based on the root density in each control volume, accounting for the role of roots in water uptake.
These methods are employed to ensure that the feedback loop between the soil water content and the ET process is accurately represented, allowing WHETGEO to adjust soil water potential based on the ET demands from GEOET.

# Key Features
- Data Coupling: BrokerGEO ensures seamless data exchange between models (e.g., WHETGEO and GEOET), allowing dynamic feedback between water flow and ET.
- ET Partitioning: Implements several methods for splitting ET into soil control volumes, ensuring accurate representation of mass and energy exchange.
- Modular Structure: New methods for partitioning ET can be added easily through the use of the Simple Factory Pattern, enabling future model expansions.
BrokerGEO is a crucial part of ecohydrological modeling, particularly when studying the interaction between surface and subsurface water processes. Its ability to dynamically adjust ET partitioning based on root and soil properties makes it an important tool for researchers modeling complex environments.


# Acknowledgements
- Concetta D’Amato, Riccardo Rigon developed the theoretical aspects of the model (Authors).
- Concetta D’Amato implemented and deployed it (Authors).

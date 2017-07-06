<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" >
	<xsl:output method="text" encoding="iso-8859-1" />
	
	<xsl:template match="/article">
		<xsl:text>% This document contains a suggestion of an ordinary article structure in Latex&#xa;&#xa;</xsl:text>
		<xsl:text>% Author: Carlos Bazilio (carlosbazilio@id.uff.br)&#xa;&#xa;</xsl:text>
		<xsl:text>\begin{document}&#xa;&#xa;</xsl:text>
		<xsl:for-each select="node()">
			<xsl:if test="name() != ''">
				<xsl:choose>
				<xsl:when test="name() != 'title' and name() != 'abstract'">
					<xsl:text>\section{</xsl:text><xsl:value-of select="name()"/><xsl:text>}</xsl:text>
					<xsl:text>&#xa;</xsl:text>
				</xsl:when>
				<xsl:when test="name() = 'title'">
					<xsl:text>\title{}&#xa;</xsl:text>
				</xsl:when>
				<xsl:otherwise>
					<xsl:text>\begin{abstract}</xsl:text>
					<xsl:text>&#xa;</xsl:text>
					<xsl:text>\end{abstract}</xsl:text>
					<xsl:text>&#xa;</xsl:text>
				</xsl:otherwise>
				</xsl:choose>
				<xsl:text>% </xsl:text><xsl:value-of select="@description"/>
				<xsl:text>&#xa;&#xa;</xsl:text>
			</xsl:if>
		</xsl:for-each>
		<xsl:text>\end{document}&#xa;</xsl:text>
	</xsl:template>
</xsl:stylesheet>

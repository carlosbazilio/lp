<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" >
	<xsl:output method="text" encoding="iso-8859-1" />
	
	<xsl:template match="/article">
		<xsl:text>% This document contains a suggestion of an ordinary article structure in Latex&#xa;&#xa;</xsl:text>
		<xsl:text>% Author: Carlos Bazilio (carlosbazilio@id.uff.br)&#xa;&#xa;</xsl:text>
		<xsl:text>% Hints: &#xa;</xsl:text>
		<xsl:text>% (1) The whole text, a section or a single paragraph *must* contain an introduction, a development and a conclusion &#xa;</xsl:text>
		<xsl:text>% (2) Due to hint (1), a single line paragraph or a single paragraph section are forbidden &#xa;</xsl:text>
		<xsl:text>% (3) Read phrases aloud in order to confirm the correct position of commas and periods &#xa;</xsl:text>
		<xsl:text>% (4) Figures, tables and any other visual stuff must always be cited and depicted in the text &#xa;</xsl:text>
		<xsl:text>% (5) Tips for writing in English (https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3935133/) &#xa;</xsl:text>
		<xsl:text>% (6) Tips for scientific writing in English (https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5175292/) &#xa;&#xa;</xsl:text>
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

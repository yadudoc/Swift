// $ANTLR 2.7.5 (20050128): "swiftscript.g" -> "SwiftScriptParser.java"$

package org.globus.swift.parser;

import org.antlr.stringtemplate.*;
import java.util.List;
import java.util.Iterator;
import antlr.Token;


import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class SwiftScriptParser extends antlr.LLkParser       implements SwiftScriptParserTokenTypes
 {

protected StringTemplateGroup m_templates=null;
protected String currentFunctionName=null;
protected SwiftScriptLexer swiftLexer=null;

public void setTemplateGroup(StringTemplateGroup tempGroup) {
    m_templates = tempGroup;
}

/** TODO this can perhaps be extracted from the superclass, but I don't
    have javadocs available at the time of writing. */
public void setSwiftLexer(SwiftScriptLexer sl) {
    swiftLexer = sl;
}

StringTemplate template(String name) {
    StringTemplate t = m_templates.getInstanceOf(name);
    t.setAttribute("sourcelocation","line "+swiftLexer.getLine());
    return t;
}

StringTemplate text(String t) {
    return new StringTemplate(m_templates,t);
}

String escape(String s) {
    String s1 = s.replaceAll("&", "&amp;");
    String s2 = s1.replaceAll("<", "&lt;");
    String s3 = s2.replaceAll(">", "&gt;");
    return s3;
}

String quote(String s) {
    String s1 = s.replaceAll("\\\\\"", "&quot;");
    String s2 = s1.replaceAll("\\\\\\\\", "\\\\");
    return s2;
}


protected SwiftScriptParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public SwiftScriptParser(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected SwiftScriptParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public SwiftScriptParser(TokenStream lexer) {
  this(lexer,2);
}

public SwiftScriptParser(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
}

	public final StringTemplate  program() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("program");
		
		
		{
		_loop3:
		do {
			if ((LA(1)==LITERAL_namespace)) {
				nsdecl(code);
			}
			else {
				break _loop3;
			}
			
		} while (true);
		}
		{
		_loop5:
		do {
			if ((LA(1)==LITERAL_import)) {
				importStatement(code);
			}
			else {
				break _loop5;
			}
			
		} while (true);
		}
		{
		_loop7:
		do {
			if ((_tokenSet_0.member(LA(1)))) {
				topLevelStatement(code);
			}
			else {
				break _loop7;
			}
			
		} while (true);
		}
		match(Token.EOF_TYPE);
		return code;
	}
	
	public final void nsdecl(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		Token  prefix = null;
		Token  uri = null;
		StringTemplate ns=template("nsDef");
		
		match(LITERAL_namespace);
		{
		switch ( LA(1)) {
		case ID:
		{
			prefix = LT(1);
			match(ID);
			if ( inputState.guessing==0 ) {
				ns.setAttribute("prefix", prefix.getText());
			}
			break;
		}
		case STRING_LITERAL:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		uri = LT(1);
		match(STRING_LITERAL);
		match(SEMI);
		if ( inputState.guessing==0 ) {
			
			ns.setAttribute("uri", uri.getText());
			code.setAttribute("namespaces", ns);
			if (ns.getAttribute("prefix") == null)
			code.setAttribute("targetNS", ns.getAttribute("uri"));
			
		}
	}
	
	public final void importStatement(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		Token  name = null;
		
		match(LITERAL_import);
		name = LT(1);
		match(STRING_LITERAL);
		match(SEMI);
		if ( inputState.guessing==0 ) {
			
			StringTemplate i = template("import");
			i.setAttribute("target", name.getText());
			code.setAttribute("imports", i);
			
		}
	}
	
	public final void topLevelStatement(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate d=null;
		
		switch ( LA(1)) {
		case LITERAL_type:
		{
			typedecl(code);
			break;
		}
		case LITERAL_if:
		case LITERAL_foreach:
		case LITERAL_iterate:
		case LITERAL_switch:
		{
			d=ll1statement();
			if ( inputState.guessing==0 ) {
				
				code.setAttribute("statements",d);
				
			}
			break;
		}
		case LITERAL_app:
		{
			d=appproceduredecl();
			if ( inputState.guessing==0 ) {
				code.setAttribute("functions",d);
			}
			break;
		}
		default:
			boolean synPredMatched26 = false;
			if (((LA(1)==ID) && (_tokenSet_1.member(LA(2))))) {
				int _m26 = mark();
				synPredMatched26 = true;
				inputState.guessing++;
				try {
					{
					predictAssignStat();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched26 = false;
				}
				rewind(_m26);
				inputState.guessing--;
			}
			if ( synPredMatched26 ) {
				d=assignStat();
				if ( inputState.guessing==0 ) {
					
					code.setAttribute("statements",d);
					
				}
			}
			else {
				boolean synPredMatched28 = false;
				if (((LA(1)==ID) && (_tokenSet_2.member(LA(2))))) {
					int _m28 = mark();
					synPredMatched28 = true;
					inputState.guessing++;
					try {
						{
						predictAppendStat();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched28 = false;
					}
					rewind(_m28);
					inputState.guessing--;
				}
				if ( synPredMatched28 ) {
					d=appendStat();
					if ( inputState.guessing==0 ) {
						
								 code.setAttribute("statements",d);
								
					}
				}
				else {
					boolean synPredMatched30 = false;
					if (((LA(1)==ID||LA(1)==LITERAL_global) && (LA(2)==ID))) {
						int _m30 = mark();
						synPredMatched30 = true;
						inputState.guessing++;
						try {
							{
							predictDeclaration();
							}
						}
						catch (RecognitionException pe) {
							synPredMatched30 = false;
						}
						rewind(_m30);
						inputState.guessing--;
					}
					if ( synPredMatched30 ) {
						declaration(code);
					}
					else {
						boolean synPredMatched32 = false;
						if (((LA(1)==ID) && (LA(2)==LPAREN))) {
							int _m32 = mark();
							synPredMatched32 = true;
							inputState.guessing++;
							try {
								{
								procedurecallCode();
								}
							}
							catch (RecognitionException pe) {
								synPredMatched32 = false;
							}
							rewind(_m32);
							inputState.guessing--;
						}
						if ( synPredMatched32 ) {
							d=procedurecallCode();
							if ( inputState.guessing==0 ) {
								
								code.setAttribute("statements",d);
								
							}
						}
						else {
							boolean synPredMatched34 = false;
							if (((LA(1)==LPAREN) && (LA(2)==ID))) {
								int _m34 = mark();
								synPredMatched34 = true;
								inputState.guessing++;
								try {
									{
									procedurecallStatAssignManyReturnParam(code);
									}
								}
								catch (RecognitionException pe) {
									synPredMatched34 = false;
								}
								rewind(_m34);
								inputState.guessing--;
							}
							if ( synPredMatched34 ) {
								procedurecallStatAssignManyReturnParam(code);
							}
							else {
								boolean synPredMatched38 = false;
								if (((LA(1)==ID||LA(1)==LPAREN) && (LA(2)==ID||LA(2)==LPAREN))) {
									int _m38 = mark();
									synPredMatched38 = true;
									inputState.guessing++;
									try {
										{
										predictProceduredecl();
										}
									}
									catch (RecognitionException pe) {
										synPredMatched38 = false;
									}
									rewind(_m38);
									inputState.guessing--;
								}
								if ( synPredMatched38 ) {
									d=proceduredecl();
									if ( inputState.guessing==0 ) {
										code.setAttribute("functions", d);
									}
								}
							else {
								throw new NoViableAltException(LT(1), getFilename());
							}
							}}}}}}
						}
						
	public final void typedecl(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		Token  id = null;
		StringTemplate r=template("typeDef");
		StringTemplate t=null;
		
		match(LITERAL_type);
		id = LT(1);
		match(ID);
		if ( inputState.guessing==0 ) {
			r.setAttribute("name", id.getText());
		}
		{
		switch ( LA(1)) {
		case SEMI:
		{
			match(SEMI);
			break;
		}
		case ID:
		{
			{
			t=type();
			if ( inputState.guessing==0 ) {
				
				r.setAttribute("type", t);
				
			}
			match(SEMI);
			}
			break;
		}
		case LCURLY:
		{
			structdecl(r);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			code.setAttribute("types", r);
		}
	}
	
	public final StringTemplate  type() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		Token  id = null;
		
		id = LT(1);
		match(ID);
		if ( inputState.guessing==0 ) {
			
			code=template("type");
			code.setAttribute("name", id.getText());
			
		}
		return code;
	}
	
	public final void structdecl(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		Token  id = null;
		Token  id1 = null;
		StringTemplate e=null, e1=null, t=null; String thisType = null;
		
		match(LCURLY);
		{
		_loop22:
		do {
			if ((LA(1)==ID)) {
				t=type();
				id = LT(1);
				match(ID);
				if ( inputState.guessing==0 ) {
					
					thisType = (String) t.getAttribute("name");
					e=template("memberdefinition");
					e.setAttribute("name", id.getText());
					
				}
				{
				_loop17:
				do {
					if ((LA(1)==LBRACK)) {
						match(LBRACK);
						match(RBRACK);
						if ( inputState.guessing==0 ) {
							thisType = thisType + "[]";
						}
					}
					else {
						break _loop17;
					}
					
				} while (true);
				}
				if ( inputState.guessing==0 ) {
					
					StringTemplate thisTypeTemplate;
					thisTypeTemplate=template("type");
					thisTypeTemplate.setAttribute("name", thisType);
					e.setAttribute("type", thisTypeTemplate);
					code.setAttribute("members", e); 
					
				}
				{
				_loop21:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						id1 = LT(1);
						match(ID);
						if ( inputState.guessing==0 ) {
							
							thisType = (String) t.getAttribute("name");
							e1=template("memberdefinition");
							e1.setAttribute("name", id1.getText());
							
						}
						{
						_loop20:
						do {
							if ((LA(1)==LBRACK)) {
								match(LBRACK);
								match(RBRACK);
								if ( inputState.guessing==0 ) {
									thisType = thisType + "[]";
								}
							}
							else {
								break _loop20;
							}
							
						} while (true);
						}
						if ( inputState.guessing==0 ) {
							
							StringTemplate thisTypeTemplate;
							thisTypeTemplate=template("type");
							thisTypeTemplate.setAttribute("name", thisType);
							e1.setAttribute("type", thisTypeTemplate);
							code.setAttribute("members", e1); 
							
						}
					}
					else {
						break _loop21;
					}
					
				} while (true);
				}
				match(SEMI);
			}
			else {
				break _loop22;
			}
			
		} while (true);
		}
		match(RCURLY);
		{
		switch ( LA(1)) {
		case SEMI:
		{
			match(SEMI);
			break;
		}
		case EOF:
		case ID:
		case LITERAL_type:
		case LITERAL_app:
		case LITERAL_global:
		case LPAREN:
		case LITERAL_if:
		case LITERAL_foreach:
		case LITERAL_iterate:
		case LITERAL_switch:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	
	public final StringTemplate  ll1statement() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		
		switch ( LA(1)) {
		case LITERAL_if:
		{
			code=ifStat();
			break;
		}
		case LITERAL_foreach:
		{
			code=foreachStat();
			break;
		}
		case LITERAL_switch:
		{
			code=switchStat();
			break;
		}
		case LITERAL_iterate:
		{
			code=iterateStat();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return code;
	}
	
	public final void predictAssignStat() throws RecognitionException, TokenStreamException {
		
		StringTemplate x=null;
		
		x=identifier();
		match(ASSIGN);
	}
	
	public final StringTemplate  assignStat() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		StringTemplate id=null;
		
		id=identifier();
		match(ASSIGN);
		{
		boolean synPredMatched156 = false;
		if (((LA(1)==ID) && (LA(2)==LPAREN))) {
			int _m156 = mark();
			synPredMatched156 = true;
			inputState.guessing++;
			try {
				{
				predictProcedurecallAssign();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched156 = false;
			}
			rewind(_m156);
			inputState.guessing--;
		}
		if ( synPredMatched156 ) {
			code=procedurecallCode();
			if ( inputState.guessing==0 ) {
				StringTemplate o = template("returnParam");
				o.setAttribute("name",id);
				code.setAttribute("outputs",o);
				
			}
		}
		else if ((_tokenSet_3.member(LA(1))) && (_tokenSet_4.member(LA(2)))) {
			code=variableAssign();
			if ( inputState.guessing==0 ) {
				
				code.setAttribute("lhs",id);
				
			}
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		return code;
	}
	
	public final void predictAppendStat() throws RecognitionException, TokenStreamException {
		
		StringTemplate x=null;
		
		x=identifier();
		match(APPEND);
	}
	
	public final StringTemplate  appendStat() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		StringTemplate id=null;
		
		id=identifier();
		match(APPEND);
		{
		boolean synPredMatched160 = false;
		if (((LA(1)==ID) && (LA(2)==LPAREN))) {
			int _m160 = mark();
			synPredMatched160 = true;
			inputState.guessing++;
			try {
				{
				predictProcedurecallAssign();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched160 = false;
			}
			rewind(_m160);
			inputState.guessing--;
		}
		if ( synPredMatched160 ) {
			code=procedurecallCode();
			if ( inputState.guessing==0 ) {
				StringTemplate o = template("returnParam");
				o.setAttribute("name",id);
				code.setAttribute("outputs",o);
				
			}
		}
		else if ((_tokenSet_3.member(LA(1))) && (_tokenSet_4.member(LA(2)))) {
			code=variableAssign();
			if ( inputState.guessing==0 ) {
				
					  // We append ["!"] to the back of the array and assign it the lhs 
					  StringTemplate c = template("arraySubscript");
					  StringTemplate st = template("sConst");
				st.setAttribute("value","_SWIFT_AUTO_INCREMENT");       	         	 
					  c.setAttribute("subscript",st);
					  c.setAttribute("array", id);
				code.setAttribute("lhs",c);          
				
			}
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		return code;
	}
	
	public final void predictDeclaration() throws RecognitionException, TokenStreamException {
		
		StringTemplate x,y;
		
		switch ( LA(1)) {
		case LITERAL_global:
		{
			{
			match(LITERAL_global);
			}
			break;
		}
		case ID:
		{
			{
			x=type();
			y=declarator();
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void declaration(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate t=null;
		boolean isGlobal = false;
		
		{
		switch ( LA(1)) {
		case LITERAL_global:
		{
			match(LITERAL_global);
			if ( inputState.guessing==0 ) {
				isGlobal = true;
			}
			break;
		}
		case ID:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		t=type();
		declpart(code, t, isGlobal);
		{
		_loop45:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				declpart(code, t, isGlobal);
			}
			else {
				break _loop45;
			}
			
		} while (true);
		}
		match(SEMI);
	}
	
	public final StringTemplate  procedurecallCode() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("call");
		
		StringTemplate f=null;
		
		procedureInvocation(code);
		return code;
	}
	
	public final void procedurecallStatAssignManyReturnParam(
		StringTemplate s
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate code=template("call");
		
		match(LPAREN);
		procedurecallStatAssignManyReturnOutput(s,code);
		{
		_loop178:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				procedurecallStatAssignManyReturnOutput(s,code);
			}
			else {
				break _loop178;
			}
			
		} while (true);
		}
		match(RPAREN);
		match(ASSIGN);
		procedureInvocation(code);
		if ( inputState.guessing==0 ) {
			
			s.setAttribute("statements",code);
			
		}
	}
	
	public final StringTemplate  appproceduredecl() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("function");
		
		Token  id = null;
		StringTemplate f=null;
		StringTemplate app=template("app");
		StringTemplate exec=null;
		
		match(LITERAL_app);
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			f=formalParameter();
			if ( inputState.guessing==0 ) {
				
				f.setAttribute("outlink", "true");
				code.setAttribute("outputs", f);
				
			}
			{
			_loop94:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					f=formalParameter();
					if ( inputState.guessing==0 ) {
						
						f.setAttribute("outlink", "true");
						code.setAttribute("outputs", f);
						
					}
				}
				else {
					break _loop94;
				}
				
			} while (true);
			}
			match(RPAREN);
			break;
		}
		case ID:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		id = LT(1);
		match(ID);
		if ( inputState.guessing==0 ) {
			currentFunctionName=id.getText();
		}
		match(LPAREN);
		{
		switch ( LA(1)) {
		case ID:
		{
			f=formalParameter();
			if ( inputState.guessing==0 ) {
				
				code.setAttribute("inputs", f);
				
			}
			{
			_loop97:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					f=formalParameter();
					if ( inputState.guessing==0 ) {
						
						code.setAttribute("inputs", f);
						
					}
				}
				else {
					break _loop97;
				}
				
			} while (true);
			}
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RPAREN);
		match(LCURLY);
		exec=declarator();
		if ( inputState.guessing==0 ) {
			app.setAttribute("exec",exec);
		}
		{
		_loop99:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				appArg(app);
			}
			else {
				break _loop99;
			}
			
		} while (true);
		}
		match(SEMI);
		if ( inputState.guessing==0 ) {
			code.setAttribute("config",app);
		}
		match(RCURLY);
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("name", id.getText());
			currentFunctionName=null;
			
		}
		return code;
	}
	
	public final void predictProceduredecl() throws RecognitionException, TokenStreamException {
		
		Token  id = null;
		StringTemplate f=null;
		
		switch ( LA(1)) {
		case ID:
		{
			{
			id = LT(1);
			match(ID);
			match(LPAREN);
			{
			switch ( LA(1)) {
			case ID:
			{
				f=formalParameter();
				{
				_loop79:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						f=formalParameter();
					}
					else {
						break _loop79;
					}
					
				} while (true);
				}
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			match(LCURLY);
			}
			break;
		}
		case LPAREN:
		{
			{
			match(LPAREN);
			f=formalParameter();
			{
			_loop82:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					f=formalParameter();
				}
				else {
					break _loop82;
				}
				
			} while (true);
			}
			match(RPAREN);
			match(ID);
			match(LPAREN);
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final StringTemplate  proceduredecl() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("function");
		
		Token  id = null;
		StringTemplate f=null;
		
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			f=formalParameter();
			if ( inputState.guessing==0 ) {
				
				f.setAttribute("outlink", "true");
				code.setAttribute("outputs", f);
				
			}
			{
			_loop86:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					f=formalParameter();
					if ( inputState.guessing==0 ) {
						
						f.setAttribute("outlink", "true");
						code.setAttribute("outputs", f);
						
					}
				}
				else {
					break _loop86;
				}
				
			} while (true);
			}
			match(RPAREN);
			break;
		}
		case ID:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		id = LT(1);
		match(ID);
		if ( inputState.guessing==0 ) {
			currentFunctionName=id.getText();
		}
		match(LPAREN);
		{
		switch ( LA(1)) {
		case ID:
		{
			f=formalParameter();
			if ( inputState.guessing==0 ) {
				
				code.setAttribute("inputs", f);
				
			}
			{
			_loop89:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					f=formalParameter();
					if ( inputState.guessing==0 ) {
						
						code.setAttribute("inputs", f);
						
					}
				}
				else {
					break _loop89;
				}
				
			} while (true);
			}
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RPAREN);
		match(LCURLY);
		{
		switch ( LA(1)) {
		case LITERAL_app:
		{
			atomicBody(code);
			break;
		}
		case ID:
		case RCURLY:
		case LITERAL_global:
		case LPAREN:
		case LITERAL_if:
		case LITERAL_foreach:
		case LITERAL_iterate:
		case LITERAL_switch:
		{
			compoundBody(code);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RCURLY);
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("name", id.getText());
			currentFunctionName=null;
			
		}
		return code;
	}
	
	public final StringTemplate  declarator() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		Token  id = null;
		
		id = LT(1);
		match(ID);
		if ( inputState.guessing==0 ) {
			code=text(id.getText());
		}
		return code;
	}
	
	public final void declpart(
		StringTemplate code, StringTemplate t, boolean isGlobal
	) throws RecognitionException, TokenStreamException {
		
		Token  f = null;
		
		StringTemplate n=null;
		StringTemplate thisTypeTemplate=null;
		String thisType = (String) t.getAttribute("name");
		StringTemplate variable=null;
		StringTemplate m = null;
		StringTemplate sTemp = null;
				String sType = "";
		
		
		n=declarator();
		{
		_loop49:
		do {
			if ((LA(1)==LBRACK)) {
				match(LBRACK);
				{
				switch ( LA(1)) {
				case ID:
				{
					sTemp=type();
					if ( inputState.guessing==0 ) {
						sType = (String) sTemp.getAttribute("name") ;
					}
					break;
				}
				case RBRACK:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(RBRACK);
				if ( inputState.guessing==0 ) {
					thisType = thisType + "[" + sType + "]" ; sType = "";
				}
			}
			else {
				break _loop49;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			
			thisTypeTemplate=template("type");
			thisTypeTemplate.setAttribute("name", thisType);
			variable = template("variable");
			variable.setAttribute("name", n);
			variable.setAttribute("type", thisTypeTemplate);
			variable.setAttribute("global", ""+isGlobal);
			code.setAttribute("statements", variable);
			
		}
		{
		switch ( LA(1)) {
		case LT:
		{
			match(LT);
			{
			switch ( LA(1)) {
			case ID:
			{
				m=mappingdecl();
				break;
			}
			case STRING_LITERAL:
			{
				f = LT(1);
				match(STRING_LITERAL);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(GT);
			if ( inputState.guessing==0 ) {
				
				if (m!=null)
				variable.setAttribute("mapping", m);
				else
				variable.setAttribute("lfn", quote(f.getText()));
				
			}
			break;
		}
		case SEMI:
		case COMMA:
		case ASSIGN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		boolean synPredMatched54 = false;
		if (((LA(1)==ASSIGN) && (LA(2)==ID))) {
			int _m54 = mark();
			synPredMatched54 = true;
			inputState.guessing++;
			try {
				{
				predictProcedurecallDecl();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched54 = false;
			}
			rewind(_m54);
			inputState.guessing--;
		}
		if ( synPredMatched54 ) {
			procedurecallDecl(code, thisTypeTemplate, n, variable);
		}
		else if ((_tokenSet_6.member(LA(1))) && (_tokenSet_7.member(LA(2)))) {
			variableDecl(code, thisTypeTemplate, n, variable);
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
	}
	
	public final StringTemplate  mappingdecl() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("mapping");
		
		StringTemplate p=null, d=null;
		
		d=declarator();
		if ( inputState.guessing==0 ) {
			code.setAttribute("descriptor",d);
		}
		match(SEMI);
		mapparamdecl(code);
		return code;
	}
	
	public final void predictProcedurecallDecl() throws RecognitionException, TokenStreamException {
		
		
		match(ASSIGN);
		match(ID);
		match(LPAREN);
	}
	
	public final void procedurecallDecl(
		StringTemplate container, StringTemplate type, StringTemplate decl, StringTemplate var
	) throws RecognitionException, TokenStreamException {
		
		
		StringTemplate code=template("call");
		StringTemplate f=template("returnParam");
		
		StringTemplate declref=template("variableReference");
		declref.setAttribute("name",decl);
		f.setAttribute("name", declref);
		code.setAttribute("outputs", f);
		container.setAttribute("statements",code);
		
		
		
		match(ASSIGN);
		procedureInvocationWithoutSemi(code);
	}
	
	public final void variableDecl(
		StringTemplate code, StringTemplate t, StringTemplate d, StringTemplate v1
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate i1=null, m=null;
		
		
		
		{
		switch ( LA(1)) {
		case ASSIGN:
		{
			i1=varInitializer();
			if ( inputState.guessing==0 ) {
				
				
				if (i1 != null) {
				StringTemplate valueAssignment = template("assign");
				StringTemplate vr = template("variableReference");
				vr.setAttribute("name",d);
				valueAssignment.setAttribute("lhs",vr);
				valueAssignment.setAttribute("rhs",i1);
				code.setAttribute("statements", valueAssignment);
				}
				
			}
			break;
		}
		case SEMI:
		case COMMA:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	
	public final StringTemplate  varInitializer() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		
		match(ASSIGN);
		code=expression();
		return code;
	}
	
	public final StringTemplate  expression() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		
		code=orExpr();
		return code;
	}
	
	public final StringTemplate  arrayInitializer() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("arrayInit");
		
		StringTemplate e=null,from=null,to=null,step=null;
		
		match(LBRACK);
		{
		boolean synPredMatched62 = false;
		if (((_tokenSet_3.member(LA(1))) && (_tokenSet_8.member(LA(2))))) {
			int _m62 = mark();
			synPredMatched62 = true;
			inputState.guessing++;
			try {
				{
				expression();
				match(COLON);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched62 = false;
			}
			rewind(_m62);
			inputState.guessing--;
		}
		if ( synPredMatched62 ) {
			{
			from=expression();
			match(COLON);
			to=expression();
			{
			switch ( LA(1)) {
			case COLON:
			{
				match(COLON);
				step=expression();
				break;
			}
			case RBRACK:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				StringTemplate range=template("range");
				range.setAttribute("from", from);
				range.setAttribute("to", to);
				if (step != null)
				range.setAttribute("step", step);
				code.setAttribute("range", range);
				
			}
			}
		}
		else if ((_tokenSet_3.member(LA(1))) && (_tokenSet_9.member(LA(2)))) {
			{
			e=expression();
			if ( inputState.guessing==0 ) {
				code.setAttribute("elements", e);
			}
			{
			_loop67:
			do {
				if ((LA(1)==COMMA) && (_tokenSet_3.member(LA(2)))) {
					match(COMMA);
					e=expression();
					if ( inputState.guessing==0 ) {
						code.setAttribute("elements", e);
					}
				}
				else {
					break _loop67;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				break;
			}
			case RBRACK:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
		}
		else if ((LA(1)==RBRACK)) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		match(RBRACK);
		return code;
	}
	
	public final void mapparamdecl(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate p=null;
		
		{
		switch ( LA(1)) {
		case ID:
		{
			p=mapparam();
			if ( inputState.guessing==0 ) {
				code.setAttribute("params", p);
			}
			{
			_loop73:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					p=mapparam();
					if ( inputState.guessing==0 ) {
						code.setAttribute("params", p);
					}
				}
				else {
					break _loop73;
				}
				
			} while (true);
			}
			break;
		}
		case GT:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
	}
	
	public final StringTemplate  mapparam() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("mapParam");
		
		StringTemplate n=null, v=null;
		
		n=declarator();
		match(ASSIGN);
		v=mappingExpr();
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("name", n);
			code.setAttribute("value", v);
			
		}
		return code;
	}
	
	public final StringTemplate  mappingExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		StringTemplate e=null;
		
		e=expression();
		if ( inputState.guessing==0 ) {
			
			code=template("mappingExpr");
			code.setAttribute("expr", e);
			
		}
		return code;
	}
	
	public final StringTemplate  formalParameter() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("parameter");
		
		StringTemplate t=null,d=null,v=null; String thisType = null;
		
		{
		t=type();
		d=declarator();
		if ( inputState.guessing==0 ) {
			
			thisType = (String) t.getAttribute("name");
			code.setAttribute("name", d);
			
		}
		{
		_loop103:
		do {
			if ((LA(1)==LBRACK)) {
				match(LBRACK);
				match(RBRACK);
				if ( inputState.guessing==0 ) {
					thisType = thisType + "[]";
				}
			}
			else {
				break _loop103;
			}
			
		} while (true);
		}
		{
		switch ( LA(1)) {
		case ASSIGN:
		{
			match(ASSIGN);
			v=constant();
			if ( inputState.guessing==0 ) {
				
				String value = (String)v.getAttribute("value");
				if (v.getName().equals("sConst")) {
				v.removeAttribute("value");
				v.setAttribute("value", quote(value));
				}
				code.setAttribute("defaultv", v);
				
			}
			break;
		}
		case COMMA:
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		}
		if ( inputState.guessing==0 ) {
			
			StringTemplate thisTypeTemplate;
			thisTypeTemplate=template("type");
			thisTypeTemplate.setAttribute("name", thisType);
			code.setAttribute("type", thisTypeTemplate);
			
		}
		return code;
	}
	
	public final void atomicBody(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate app=null, svc=null;
		
		app=appSpec();
		if ( inputState.guessing==0 ) {
			code.setAttribute("config",app);
		}
	}
	
	public final void compoundBody(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		
		{
		_loop111:
		do {
			if ((_tokenSet_10.member(LA(1)))) {
				innerStatement(code);
			}
			else {
				break _loop111;
			}
			
		} while (true);
		}
	}
	
	public final void appArg(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate arg=null;
		
		switch ( LA(1)) {
		case ID:
		case STRING_LITERAL:
		case LBRACK:
		case LPAREN:
		case AT:
		case PLUS:
		case MINUS:
		case NOT:
		case INT_LITERAL:
		case FLOAT_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		{
			arg=mappingExpr();
			if ( inputState.guessing==0 ) {
				code.setAttribute("arguments", arg);
			}
			break;
		}
		case LITERAL_stdin:
		case LITERAL_stdout:
		case LITERAL_stderr:
		{
			stdioArg(code);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final StringTemplate  constant() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		Token  i = null;
		Token  d = null;
		Token  s = null;
		Token  t = null;
		Token  f = null;
		
		switch ( LA(1)) {
		case INT_LITERAL:
		{
			i = LT(1);
			match(INT_LITERAL);
			if ( inputState.guessing==0 ) {
				
				code=template("iConst");
				code.setAttribute("value",i.getText());
				
			}
			break;
		}
		case FLOAT_LITERAL:
		{
			d = LT(1);
			match(FLOAT_LITERAL);
			if ( inputState.guessing==0 ) {
				
				code=template("fConst");
				code.setAttribute("value",d.getText());
				
			}
			break;
		}
		case STRING_LITERAL:
		{
			s = LT(1);
			match(STRING_LITERAL);
			if ( inputState.guessing==0 ) {
				
				code=template("sConst");
				code.setAttribute("value",quote(s.getText()));
				
			}
			break;
		}
		case LITERAL_true:
		{
			t = LT(1);
			match(LITERAL_true);
			if ( inputState.guessing==0 ) {
				
				code=template("bConst");
				code.setAttribute("value", t.getText());
				
			}
			break;
		}
		case LITERAL_false:
		{
			f = LT(1);
			match(LITERAL_false);
			if ( inputState.guessing==0 ) {
				
				code=template("bConst");
				code.setAttribute("value", f.getText());
				
			}
			break;
		}
		case LBRACK:
		{
			code=arrayInitializer();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return code;
	}
	
	public final void compoundStat(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		
		match(LCURLY);
		{
		_loop108:
		do {
			if ((_tokenSet_10.member(LA(1)))) {
				innerStatement(code);
			}
			else {
				break _loop108;
			}
			
		} while (true);
		}
		match(RCURLY);
	}
	
	public final void innerStatement(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate s=null;
		
		boolean synPredMatched114 = false;
		if (((LA(1)==ID||LA(1)==LITERAL_global) && (LA(2)==ID))) {
			int _m114 = mark();
			synPredMatched114 = true;
			inputState.guessing++;
			try {
				{
				predictDeclaration();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched114 = false;
			}
			rewind(_m114);
			inputState.guessing--;
		}
		if ( synPredMatched114 ) {
			declaration(code);
		}
		else if ((_tokenSet_11.member(LA(1))) && (_tokenSet_12.member(LA(2)))) {
			{
			{
			if ((_tokenSet_13.member(LA(1)))) {
				s=ll1statement();
			}
			else {
				boolean synPredMatched118 = false;
				if (((LA(1)==ID) && (LA(2)==LPAREN))) {
					int _m118 = mark();
					synPredMatched118 = true;
					inputState.guessing++;
					try {
						{
						procedurecallCode();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched118 = false;
					}
					rewind(_m118);
					inputState.guessing--;
				}
				if ( synPredMatched118 ) {
					s=procedurecallCode();
				}
				else {
					boolean synPredMatched120 = false;
					if (((LA(1)==ID) && (_tokenSet_1.member(LA(2))))) {
						int _m120 = mark();
						synPredMatched120 = true;
						inputState.guessing++;
						try {
							{
							predictAssignStat();
							}
						}
						catch (RecognitionException pe) {
							synPredMatched120 = false;
						}
						rewind(_m120);
						inputState.guessing--;
					}
					if ( synPredMatched120 ) {
						s=assignStat();
					}
					else {
						boolean synPredMatched122 = false;
						if (((LA(1)==ID) && (_tokenSet_2.member(LA(2))))) {
							int _m122 = mark();
							synPredMatched122 = true;
							inputState.guessing++;
							try {
								{
								predictAppendStat();
								}
							}
							catch (RecognitionException pe) {
								synPredMatched122 = false;
							}
							rewind(_m122);
							inputState.guessing--;
						}
						if ( synPredMatched122 ) {
							s=appendStat();
						}
						else {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}}}
						}
						if ( inputState.guessing==0 ) {
							
							code.setAttribute("statements",s);
							
						}
						}
					}
					else {
						boolean synPredMatched124 = false;
						if (((LA(1)==LPAREN))) {
							int _m124 = mark();
							synPredMatched124 = true;
							inputState.guessing++;
							try {
								{
								procedurecallStatAssignManyReturnParam(code);
								}
							}
							catch (RecognitionException pe) {
								synPredMatched124 = false;
							}
							rewind(_m124);
							inputState.guessing--;
						}
						if ( synPredMatched124 ) {
							procedurecallStatAssignManyReturnParam(code);
						}
						else {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					
	public final void caseInnerStatement(
		StringTemplate statements
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate code = null;
		
		switch ( LA(1)) {
		case ID:
		case LITERAL_if:
		case LITERAL_foreach:
		case LITERAL_iterate:
		case LITERAL_switch:
		{
			{
			if ((_tokenSet_13.member(LA(1)))) {
				code=ll1statement();
			}
			else {
				boolean synPredMatched128 = false;
				if (((LA(1)==ID) && (LA(2)==LPAREN))) {
					int _m128 = mark();
					synPredMatched128 = true;
					inputState.guessing++;
					try {
						{
						procedurecallCode();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched128 = false;
					}
					rewind(_m128);
					inputState.guessing--;
				}
				if ( synPredMatched128 ) {
					code=procedurecallCode();
				}
				else {
					boolean synPredMatched130 = false;
					if (((LA(1)==ID) && (_tokenSet_1.member(LA(2))))) {
						int _m130 = mark();
						synPredMatched130 = true;
						inputState.guessing++;
						try {
							{
							predictAssignStat();
							}
						}
						catch (RecognitionException pe) {
							synPredMatched130 = false;
						}
						rewind(_m130);
						inputState.guessing--;
					}
					if ( synPredMatched130 ) {
						code=assignStat();
					}
					else {
						boolean synPredMatched132 = false;
						if (((LA(1)==ID) && (_tokenSet_2.member(LA(2))))) {
							int _m132 = mark();
							synPredMatched132 = true;
							inputState.guessing++;
							try {
								{
								predictAppendStat();
								}
							}
							catch (RecognitionException pe) {
								synPredMatched132 = false;
							}
							rewind(_m132);
							inputState.guessing--;
						}
						if ( synPredMatched132 ) {
							code=appendStat();
						}
						else {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}}}
						}
						if ( inputState.guessing==0 ) {
							statements.setAttribute("statements",code);
						}
						break;
					}
					case LPAREN:
					{
						procedurecallStatAssignManyReturnParam(statements);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				
	public final StringTemplate  ifStat() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("if");
		
		
		StringTemplate cond=null;
		StringTemplate body=template("statementList");
		StringTemplate els=template("statementList");
		
		
		match(LITERAL_if);
		match(LPAREN);
		cond=expression();
		match(RPAREN);
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("cond", cond);
			
		}
		compoundStat(body);
		if ( inputState.guessing==0 ) {
			code.setAttribute("body", body);
		}
		{
		switch ( LA(1)) {
		case LITERAL_else:
		{
			match(LITERAL_else);
			compoundStat(els);
			if ( inputState.guessing==0 ) {
				code.setAttribute("els", els);
			}
			break;
		}
		case EOF:
		case ID:
		case LITERAL_type:
		case RCURLY:
		case LITERAL_app:
		case LITERAL_global:
		case LPAREN:
		case LITERAL_if:
		case LITERAL_foreach:
		case LITERAL_iterate:
		case LITERAL_switch:
		case LITERAL_case:
		case LITERAL_default:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return code;
	}
	
	public final StringTemplate  foreachStat() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("foreach");
		
		Token  id = null;
		Token  indexId = null;
		
		StringTemplate ds=null;
		StringTemplate body=template("statementList");
		
		
		match(LITERAL_foreach);
		id = LT(1);
		match(ID);
		{
		switch ( LA(1)) {
		case COMMA:
		{
			match(COMMA);
			indexId = LT(1);
			match(ID);
			break;
		}
		case LITERAL_in:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(LITERAL_in);
		ds=expression();
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("var", id.getText());
			code.setAttribute("in", ds);
			if (indexId != null) {
			code.setAttribute("index", indexId.getText());           
			}
			
		}
		compoundStat(body);
		if ( inputState.guessing==0 ) {
			code.setAttribute("body", body);
		}
		return code;
	}
	
	public final StringTemplate  switchStat() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("switch");
		
		
		StringTemplate cond=null, b=null;
		
		
		match(LITERAL_switch);
		match(LPAREN);
		cond=expression();
		match(RPAREN);
		if ( inputState.guessing==0 ) {
			code.setAttribute("cond", cond);
		}
		match(LCURLY);
		{
		_loop143:
		do {
			if ((LA(1)==LITERAL_case||LA(1)==LITERAL_default)) {
				b=casesGroup();
				if ( inputState.guessing==0 ) {
					code.setAttribute("cases", b);
				}
			}
			else {
				break _loop143;
			}
			
		} while (true);
		}
		match(RCURLY);
		return code;
	}
	
	public final StringTemplate  iterateStat() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("iterate");
		
		Token  id = null;
		
		StringTemplate cond=null;
		StringTemplate body=template("statementList");
		
		
		match(LITERAL_iterate);
		id = LT(1);
		match(ID);
		compoundStat(body);
		if ( inputState.guessing==0 ) {
			code.setAttribute("body", body);
		}
		match(LITERAL_until);
		match(LPAREN);
		cond=expression();
		match(RPAREN);
		match(SEMI);
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("var", id.getText());
			code.setAttribute("cond", cond);
			
		}
		return code;
	}
	
	public final StringTemplate  casesGroup() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("case");
		
		StringTemplate b=null;
		
		{
		aCase(code);
		}
		caseSList(code);
		return code;
	}
	
	public final void aCase(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate v=null;
		
		{
		switch ( LA(1)) {
		case LITERAL_case:
		{
			match(LITERAL_case);
			v=expression();
			if ( inputState.guessing==0 ) {
				code.setAttribute("value", v);
			}
			break;
		}
		case LITERAL_default:
		{
			match(LITERAL_default);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(COLON);
	}
	
	public final void caseSList(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate s=null;
		
		{
		_loop150:
		do {
			if ((_tokenSet_14.member(LA(1)))) {
				caseInnerStatement(code);
			}
			else {
				break _loop150;
			}
			
		} while (true);
		}
	}
	
	public final StringTemplate  identifier() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		Token  base = null;
		
		StringTemplate c=null;
		code=template("variableReference");
		
		
		base = LT(1);
		match(ID);
		if ( inputState.guessing==0 ) {
			code.setAttribute("name",base.getText());
		}
		{
		_loop240:
		do {
			if ((LA(1)==LBRACK) && (_tokenSet_15.member(LA(2)))) {
				{
				c=arrayIndex();
				if ( inputState.guessing==0 ) {
					c.setAttribute("array",code); code=c;
				}
				}
			}
			else if ((LA(1)==DOT)) {
				{
				c=memberName();
				if ( inputState.guessing==0 ) {
					c.setAttribute("structure",code); code=c;
				}
				}
			}
			else {
				break _loop240;
			}
			
		} while (true);
		}
		return code;
	}
	
	public final void predictProcedurecallAssign() throws RecognitionException, TokenStreamException {
		
		
		match(ID);
		match(LPAREN);
	}
	
	public final StringTemplate  variableAssign() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		StringTemplate a=null, e=null, id=null;
		
		e=expression();
		match(SEMI);
		if ( inputState.guessing==0 ) {
			
			code=template("assign");
			code.setAttribute("rhs", e);
			
		}
		return code;
	}
	
	public final void procedureInvocation(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		
		procedureInvocationWithoutSemi(code);
		match(SEMI);
	}
	
	public final void procedureInvocationWithoutSemi(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		Token  id = null;
		StringTemplate f=null;
		
		id = LT(1);
		match(ID);
		if ( inputState.guessing==0 ) {
			code.setAttribute("func", id.getText());
		}
		match(LPAREN);
		{
		switch ( LA(1)) {
		case ID:
		case STRING_LITERAL:
		case LBRACK:
		case LPAREN:
		case AT:
		case PLUS:
		case MINUS:
		case NOT:
		case INT_LITERAL:
		case FLOAT_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		{
			f=actualParameter();
			if ( inputState.guessing==0 ) {
				
				code.setAttribute("inputs", f);
				
			}
			{
			_loop168:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					f=actualParameter();
					if ( inputState.guessing==0 ) {
						
						code.setAttribute("inputs", f);
						
					}
				}
				else {
					break _loop168;
				}
				
			} while (true);
			}
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RPAREN);
	}
	
	public final StringTemplate  actualParameter() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("actualParam");
		
		StringTemplate d=null, id=null, ai=null;
		
		{
		boolean synPredMatched189 = false;
		if (((LA(1)==ID) && (LA(2)==ASSIGN))) {
			int _m189 = mark();
			synPredMatched189 = true;
			inputState.guessing++;
			try {
				{
				declarator();
				match(ASSIGN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched189 = false;
			}
			rewind(_m189);
			inputState.guessing--;
		}
		if ( synPredMatched189 ) {
			{
			d=declarator();
			match(ASSIGN);
			}
			if ( inputState.guessing==0 ) {
				
				code.setAttribute("bind", d);
				
			}
		}
		else if ((_tokenSet_3.member(LA(1))) && (_tokenSet_16.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		id=expression();
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("value", id);
			
		}
		return code;
	}
	
	public final void procedureInvocationExpr(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		Token  id = null;
		StringTemplate f=null;
		
		id = LT(1);
		match(ID);
		if ( inputState.guessing==0 ) {
			code.setAttribute("func", id.getText());
		}
		match(LPAREN);
		{
		switch ( LA(1)) {
		case ID:
		case STRING_LITERAL:
		case LBRACK:
		case LPAREN:
		case AT:
		case PLUS:
		case MINUS:
		case NOT:
		case INT_LITERAL:
		case FLOAT_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		{
			f=actualParameter();
			if ( inputState.guessing==0 ) {
				
						code.setAttribute("inputs", f);
					
			}
			{
			_loop172:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					f=actualParameter();
					if ( inputState.guessing==0 ) {
						
									code.setAttribute("inputs", f);
							
					}
				}
				else {
					break _loop172;
				}
				
			} while (true);
			}
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RPAREN);
	}
	
	public final StringTemplate  procedureCallExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("call");
		
		StringTemplate f=null;
		
		procedureInvocationExpr(code);
		return code;
	}
	
	public final void procedurecallStatAssignManyReturnOutput(
		StringTemplate s, StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate var = null, f = null;
		
		f=returnParameter();
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("outputs", f);
			var = template("variable");
			if(f.getAttribute("type") != null) {
			StringTemplate nameST = (StringTemplate)f.getAttribute("name");
			var.setAttribute("name",nameST.getAttribute("name"));
			var.setAttribute("type",f.getAttribute("type"));
			var.setAttribute("global", Boolean.FALSE);
			
			s.setAttribute("statements",var);
			}
			
		}
	}
	
	public final StringTemplate  returnParameter() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("returnParam");
		
		StringTemplate t=null, id=null, d=null;
		
		{
		if ((LA(1)==ID) && (LA(2)==ID)) {
			t=type();
			if ( inputState.guessing==0 ) {
				code.setAttribute("type", t);
			}
		}
		else if ((LA(1)==ID) && (_tokenSet_17.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		id=identifier();
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("name", id);
			
		}
		{
		switch ( LA(1)) {
		case ASSIGN:
		{
			{
			match(ASSIGN);
			d=declarator();
			}
			if ( inputState.guessing==0 ) {
				
				code.setAttribute("bind", d);
				
			}
			break;
		}
		case COMMA:
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return code;
	}
	
	public final StringTemplate  appSpec() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("app");
		
		StringTemplate exec=null;
		
		match(LITERAL_app);
		match(LCURLY);
		exec=declarator();
		if ( inputState.guessing==0 ) {
			code.setAttribute("exec", exec);
		}
		{
		_loop194:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				appArg(code);
			}
			else {
				break _loop194;
			}
			
		} while (true);
		}
		match(SEMI);
		match(RCURLY);
		return code;
	}
	
	public final void stdioArg(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate t=null,m=null; String name=null;
		
		{
		switch ( LA(1)) {
		case LITERAL_stdin:
		{
			match(LITERAL_stdin);
			if ( inputState.guessing==0 ) {
				t=template("stdin"); name="stdin";
			}
			break;
		}
		case LITERAL_stdout:
		{
			match(LITERAL_stdout);
			if ( inputState.guessing==0 ) {
				t=template("stdout"); name="stdout";
			}
			break;
		}
		case LITERAL_stderr:
		{
			match(LITERAL_stderr);
			if ( inputState.guessing==0 ) {
				t=template("stderr"); name="stderr";
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(ASSIGN);
		m=mappingExpr();
		if ( inputState.guessing==0 ) {
			
			t.setAttribute("content", m);
			code.setAttribute(name, t);
			
		}
	}
	
	public final StringTemplate  functionInvocation() throws RecognitionException, TokenStreamException {
		StringTemplate code=template("functionInvocation");
		
		StringTemplate func=null, e=null;
		
		match(AT);
		{
		boolean synPredMatched200 = false;
		if (((LA(1)==ID) && (LA(2)==LPAREN))) {
			int _m200 = mark();
			synPredMatched200 = true;
			inputState.guessing++;
			try {
				{
				declarator();
				match(LPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched200 = false;
			}
			rewind(_m200);
			inputState.guessing--;
		}
		if ( synPredMatched200 ) {
			{
			func=declarator();
			if ( inputState.guessing==0 ) {
				
				code.setAttribute("name", func);
				
			}
			match(LPAREN);
			{
			switch ( LA(1)) {
			case ID:
			case STRING_LITERAL:
			case LBRACK:
			case LPAREN:
			case AT:
			case PLUS:
			case MINUS:
			case NOT:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case LITERAL_true:
			case LITERAL_false:
			{
				functionInvocationArgument(code);
				{
				_loop204:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						functionInvocationArgument(code);
					}
					else {
						break _loop204;
					}
					
				} while (true);
				}
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			}
		}
		else if ((LA(1)==ID||LA(1)==LPAREN) && (_tokenSet_18.member(LA(2)))) {
			{
			switch ( LA(1)) {
			case ID:
			{
				e=identifier();
				break;
			}
			case LPAREN:
			{
				{
				match(LPAREN);
				e=identifier();
				match(RPAREN);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				code.setAttribute("name", "filename");
				code.setAttribute("args", e);
				
			}
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		return code;
	}
	
	public final void functionInvocationArgument(
		StringTemplate code
	) throws RecognitionException, TokenStreamException {
		
		StringTemplate e = null;
		
		e=expression();
		if ( inputState.guessing==0 ) {
			
			code.setAttribute("args", e);
			
		}
	}
	
	public final StringTemplate  orExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		StringTemplate a,b;
		
		code=andExpr();
		{
		_loop213:
		do {
			if ((LA(1)==OR)) {
				match(OR);
				b=andExpr();
				if ( inputState.guessing==0 ) {
					
					a = code;
					code=template("or");
					code.setAttribute("left", a);
					code.setAttribute("right", b);
					
				}
			}
			else {
				break _loop213;
			}
			
		} while (true);
		}
		return code;
	}
	
	public final StringTemplate  andExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		StringTemplate a,b;
		
		code=equalExpr();
		{
		_loop216:
		do {
			if ((LA(1)==AND)) {
				match(AND);
				b=equalExpr();
				if ( inputState.guessing==0 ) {
					
					a = code;
					code=template("and");
					code.setAttribute("left", a);
					code.setAttribute("right", b);
					
				}
			}
			else {
				break _loop216;
			}
			
		} while (true);
		}
		return code;
	}
	
	public final StringTemplate  equalExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		
		StringTemplate a,b=null;
		Token op=null;
		
		
		code=condExpr();
		{
		switch ( LA(1)) {
		case EQ:
		case NE:
		{
			if ( inputState.guessing==0 ) {
				op=LT(1);
			}
			{
			switch ( LA(1)) {
			case EQ:
			{
				match(EQ);
				break;
			}
			case NE:
			{
				match(NE);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			b=condExpr();
			if ( inputState.guessing==0 ) {
				
				a = code;
				code=template("cond");
				code.setAttribute("op", escape(op.getText()));
				code.setAttribute("left", a);
				code.setAttribute("right", b);
				
			}
			break;
		}
		case ID:
		case STRING_LITERAL:
		case SEMI:
		case LCURLY:
		case LBRACK:
		case RBRACK:
		case COMMA:
		case GT:
		case COLON:
		case LPAREN:
		case RPAREN:
		case AT:
		case LITERAL_stdin:
		case LITERAL_stdout:
		case LITERAL_stderr:
		case OR:
		case AND:
		case PLUS:
		case MINUS:
		case NOT:
		case INT_LITERAL:
		case FLOAT_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return code;
	}
	
	public final StringTemplate  condExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		
		StringTemplate a,b=null;
		Token op=null;
		
		
		code=additiveExpr();
		{
		if ((_tokenSet_19.member(LA(1))) && (_tokenSet_3.member(LA(2)))) {
			if ( inputState.guessing==0 ) {
				op=LT(1);
			}
			{
			switch ( LA(1)) {
			case LT:
			{
				match(LT);
				break;
			}
			case LE:
			{
				match(LE);
				break;
			}
			case GT:
			{
				match(GT);
				break;
			}
			case GE:
			{
				match(GE);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			b=additiveExpr();
			if ( inputState.guessing==0 ) {
				
				a = code;
				code=template("cond");
				code.setAttribute("op", escape(op.getText()));
				code.setAttribute("left", a);
				code.setAttribute("right", b);
				
			}
		}
		else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_21.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		return code;
	}
	
	public final StringTemplate  additiveExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		
		StringTemplate a,b=null;
		Token op=null;
		
		
		code=multiExpr();
		{
		_loop226:
		do {
			if ((LA(1)==PLUS||LA(1)==MINUS) && (_tokenSet_3.member(LA(2)))) {
				if ( inputState.guessing==0 ) {
					op=LT(1);
				}
				{
				switch ( LA(1)) {
				case PLUS:
				{
					match(PLUS);
					break;
				}
				case MINUS:
				{
					match(MINUS);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				b=multiExpr();
				if ( inputState.guessing==0 ) {
					
					a = code;
					code=template("arith");
					code.setAttribute("op", escape(op.getText()));
					code.setAttribute("left", a);
					code.setAttribute("right", b);
					
				}
			}
			else {
				break _loop226;
			}
			
		} while (true);
		}
		return code;
	}
	
	public final StringTemplate  multiExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		
		StringTemplate a,b=null;
		Token op=null;
		
		
		code=unaryExpr();
		{
		_loop230:
		do {
			if (((LA(1) >= STAR && LA(1) <= MOD))) {
				if ( inputState.guessing==0 ) {
					op=LT(1);
				}
				{
				switch ( LA(1)) {
				case STAR:
				{
					match(STAR);
					break;
				}
				case IDIV:
				{
					match(IDIV);
					break;
				}
				case FDIV:
				{
					match(FDIV);
					break;
				}
				case MOD:
				{
					match(MOD);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				b=unaryExpr();
				if ( inputState.guessing==0 ) {
					
					a = code;
					code=template("arith");
					code.setAttribute("op", escape(op.getText()));
					code.setAttribute("left", a);
					code.setAttribute("right", b);
					
				}
			}
			else {
				break _loop230;
			}
			
		} while (true);
		}
		return code;
	}
	
	public final StringTemplate  unaryExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		StringTemplate u=null;
		
		switch ( LA(1)) {
		case MINUS:
		{
			match(MINUS);
			u=unaryExpr();
			if ( inputState.guessing==0 ) {
				code=template("unaryNegation"); code.setAttribute("exp", u);
			}
			break;
		}
		case PLUS:
		{
			match(PLUS);
			u=unaryExpr();
			if ( inputState.guessing==0 ) {
				code=u;
			}
			break;
		}
		case NOT:
		{
			match(NOT);
			u=unaryExpr();
			if ( inputState.guessing==0 ) {
				code=template("not"); code.setAttribute("exp", u);
			}
			break;
		}
		case ID:
		case STRING_LITERAL:
		case LBRACK:
		case LPAREN:
		case AT:
		case INT_LITERAL:
		case FLOAT_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		{
			code=primExpr();
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return code;
	}
	
	public final StringTemplate  primExpr() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		StringTemplate id=null, exp=null;
		
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			exp=orExpr();
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				code=template("paren");
				code.setAttribute("exp", exp);
			}
			break;
		}
		case STRING_LITERAL:
		case LBRACK:
		case INT_LITERAL:
		case FLOAT_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		{
			code=constant();
			break;
		}
		case AT:
		{
			code=functionInvocation();
			break;
		}
		default:
			boolean synPredMatched234 = false;
			if (((LA(1)==ID) && (LA(2)==LPAREN))) {
				int _m234 = mark();
				synPredMatched234 = true;
				inputState.guessing++;
				try {
					{
					predictProcedureCallExpr();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched234 = false;
				}
				rewind(_m234);
				inputState.guessing--;
			}
			if ( synPredMatched234 ) {
				code=procedureCallExpr();
			}
			else if ((LA(1)==ID) && (_tokenSet_18.member(LA(2)))) {
				code=identifier();
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return code;
	}
	
	public final void predictProcedureCallExpr() throws RecognitionException, TokenStreamException {
		
		
		match(ID);
		match(LPAREN);
	}
	
	public final StringTemplate  arrayIndex() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		Token  s = null;
		StringTemplate e=null;
		
		match(LBRACK);
		{
		switch ( LA(1)) {
		case ID:
		case STRING_LITERAL:
		case LBRACK:
		case LPAREN:
		case AT:
		case PLUS:
		case MINUS:
		case NOT:
		case INT_LITERAL:
		case FLOAT_LITERAL:
		case LITERAL_true:
		case LITERAL_false:
		{
			e=expression();
			break;
		}
		case STAR:
		{
			s = LT(1);
			match(STAR);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RBRACK);
		if ( inputState.guessing==0 ) {
			
			code=template("arraySubscript");
			if(e != null) code.setAttribute("subscript",e);
			if(s != null) {
			StringTemplate st = template("sConst");
			st.setAttribute("value","*");
			code.setAttribute("subscript",st);
			}
			
		}
		return code;
	}
	
	public final StringTemplate  memberName() throws RecognitionException, TokenStreamException {
		StringTemplate code=null;
		
		Token  d = null;
		Token  member = null;
		Token  s = null;
		
		d = LT(1);
		match(DOT);
		{
		switch ( LA(1)) {
		case ID:
		{
			member = LT(1);
			match(ID);
			break;
		}
		case STAR:
		{
			s = LT(1);
			match(STAR);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			
			code=template("memberAccess");
			if(member != null) code.setAttribute("name",member.getText());
			if(s != null) code.setAttribute("name","*");
			
		}
		return code;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"namespace\"",
		"an identifier",
		"STRING_LITERAL",
		"a semicolon",
		"\"import\"",
		"\"type\"",
		"'{'",
		"'['",
		"']'",
		"COMMA",
		"'}'",
		"\"app\"",
		"\"global\"",
		"LT",
		"GT",
		"ASSIGN",
		"COLON",
		"'('",
		"')'",
		"\"if\"",
		"\"else\"",
		"\"foreach\"",
		"\"in\"",
		"\"iterate\"",
		"\"until\"",
		"\"switch\"",
		"\"case\"",
		"\"default\"",
		"APPEND",
		"AT",
		"\"stdin\"",
		"\"stdout\"",
		"\"stderr\"",
		"OR",
		"AND",
		"EQ",
		"NE",
		"LE",
		"GE",
		"PLUS",
		"MINUS",
		"STAR",
		"IDIV",
		"FDIV",
		"MOD",
		"NOT",
		"DOT",
		"INT_LITERAL",
		"FLOAT_LITERAL",
		"\"true\"",
		"\"false\"",
		"NUMBER",
		"INTPART",
		"ANYDIGIT",
		"FLOATPART",
		"EXPONENT",
		"WS",
		"SL_CCOMMENT",
		"SL_SCOMMENT",
		"ML_COMMENT",
		"ESC"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 715227680L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 1125899907368960L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 1125904201811968L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 34366344029800544L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 36028668172441824L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 34366464288884832L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 532608L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 34366344742947426L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 36028668173490272L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 36028668172449888L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 715194400L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 713031712L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 1125904204433440L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 713031680L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 715128864L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 34401528401889376L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 36028668176644192L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 1125899911571456L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 36028788436778208L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 6597070159872L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 34368525878705376L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 36028796666642146L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	
	}
